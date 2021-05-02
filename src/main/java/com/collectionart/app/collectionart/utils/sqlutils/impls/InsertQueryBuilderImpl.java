package com.collectionart.app.collectionart.utils.sqlutils.impls;

import com.collectionart.app.collectionart.common.CannotBuildException;
import com.collectionart.app.collectionart.common.CustomStringBuilder;
import com.collectionart.app.collectionart.common.impl.SimpleCustomStringBuilder;
import com.collectionart.app.collectionart.utils.CommonUtils;
import com.collectionart.app.collectionart.utils.sqlutils.InsertQueryBuilder;
import com.collectionart.app.collectionart.utils.sqlutils.SqlConstants;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

public class InsertQueryBuilderImpl implements InsertQueryBuilder {

    private static final String COLUMN_ARG_NAME = "column";

    private static final String COLUMN_MAP_ARG_NAME = "columnMap";

    private final String tableName;

    private final EntityManager entityManager;

    private final CustomStringBuilder columnsBuilder;

    private final CustomStringBuilder valuesBuilder;

    private final Map<Integer, Object> parameters;

    private int index = 0;

    public InsertQueryBuilderImpl(String tableName, EntityManager entityManager) {
        this.tableName = tableName;
        this.entityManager = entityManager;
        this.columnsBuilder = new SimpleCustomStringBuilder();
        this.valuesBuilder = new SimpleCustomStringBuilder();
        this.parameters = new HashMap<>();
    }

    private void increaseIndex() {
        ++index;
    }

    private void appendCommaAndSpace() {
        this.columnsBuilder.appendComma().appendSpace();
        this.valuesBuilder.appendComma().appendSpace();
    }

    private InsertQueryBuilder doSetColumn(String column, Object value) {
        this.increaseIndex();
        if (index > 1) {
            this.appendCommaAndSpace();
        }
        this.columnsBuilder.append(column);
        this.valuesBuilder.appendQuestionMask();

        this.parameters.put(index, value);

        return this;
    }

    @Override
    public InsertQueryBuilder setColumn(String column, Object value) {
        CommonUtils.require(COLUMN_ARG_NAME, column);
        return doSetColumn(column, value);
    }

    @Override
    public InsertQueryBuilder setColumns(Map<String, Object> columnMap) {
        CommonUtils.require(COLUMN_MAP_ARG_NAME, columnMap);
        columnMap.forEach(this::setColumn);
        return this;
    }

    private String compileSql() {
        return new SimpleCustomStringBuilder(SqlConstants.INSERT)
                .appendSpace()
                .append(SqlConstants.INTO)
                .appendSpace()
                .append(tableName)
                .append(this.columnsBuilder.wrapParenthesis())
                .appendSpace()
                .append(SqlConstants.VALUES)
                .append(this.valuesBuilder.wrapParenthesis())
                .toString();
    }

    @Override
    public Query build() {
        if(index == 0) {
            throw new CannotBuildException("Cannot build without column !");
        }

        Query query = this.entityManager.createNativeQuery(this.compileSql());
        this.parameters.forEach(query::setParameter);
        return query;
    }
}

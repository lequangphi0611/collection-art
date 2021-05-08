package com.collectionart.app.collectionart.repositories.impl;

import com.collectionart.app.collectionart.common.ArgumentInCorrectException;
import com.collectionart.app.collectionart.repositories.HistoryRepository;
import com.collectionart.app.collectionart.utils.CollectionUtils;
import com.collectionart.app.collectionart.utils.CommonUtils;
import com.collectionart.app.collectionart.utils.StringUtils;
import com.collectionart.app.collectionart.utils.sqlutils.InsertQueryBuilder;
import com.collectionart.app.collectionart.utils.sqlutils.QueryBuilderFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class MapObjectHistoryRepository implements HistoryRepository<Map<String, Object>> {

    private static final String BEFORE_KEY_PREFIX = "before_";

    private static final String AFTER_KEY_PREFIX = "after_";

    private final String tableName;

    private final EntityManager entityManager;

    private final Set<String> keys;

    private final Set<String> nonHistoryColumns;

    public MapObjectHistoryRepository(String tableName,
                                      EntityManager entityManager,
                                      Set<String> keys,
                                      Set<String> nonHistoryColumns
    ) {
        this.tableName = tableName;
        this.entityManager = entityManager;
        this.keys = keys;
        this.nonHistoryColumns = nonHistoryColumns;
    }

    private Query buildQuery(Map<String, Object> beforeHistory, Map<String, Object> afterHistory) {

        InsertQueryBuilder insertQueryBuilder = CollectionUtils.reduce(keys, QueryBuilderFactory
                .createInsertBuilder(this.tableName, this.entityManager), (builder, key) -> {
            if (this.nonHistoryColumns.contains(key)) {
                builder.setColumn(key, afterHistory.get(key));
                return builder;
            }

            String beforeKey = StringUtils.applyPrefix(BEFORE_KEY_PREFIX, key);
            String afterKey = StringUtils.applyPrefix(AFTER_KEY_PREFIX, key);
            Object beforeValue = beforeHistory.get(key);
            Object afterValue = afterHistory.get(key);

            builder.setColumn(beforeKey, beforeValue);
            builder.setColumn(afterKey, afterValue);

            return builder;
        });

        return insertQueryBuilder.build();
    }

    private Query createHistoryQuery(Map<String, Object> beforeHistory, Map<String, Object> afterHistory) {
        Map<String, Object> before = CommonUtils.defaults(beforeHistory, Collections.emptyMap());
        Map<String, Object> after = CommonUtils.defaults(afterHistory, Collections.emptyMap());

        if (before.isEmpty() && after.isEmpty()) {
            throw new ArgumentInCorrectException("[beforeHistory] and [afterHistory] can not be null or empty!");
        }

        return buildQuery(before, after);
    }

    @Override
    public void insertHistory(Map<String, Object> beforeEntity, Map<String, Object> afterEntity) {
        this.createHistoryQuery(beforeEntity, afterEntity).executeUpdate();
    }

}

package com.collectionart.app.collectionart.utils.sqlutils;

import com.collectionart.app.collectionart.common.Buildable;

import java.util.Map;

public interface InsertQueryBuilder extends QueryBuilder {

    InsertQueryBuilder setColumn(String column, Object value);

    InsertQueryBuilder setColumns(Map<String, Object> columnMap);

}

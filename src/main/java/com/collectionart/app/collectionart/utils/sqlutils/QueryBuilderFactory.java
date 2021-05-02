package com.collectionart.app.collectionart.utils.sqlutils;

import com.collectionart.app.collectionart.utils.sqlutils.impls.InsertQueryBuilderImpl;

import javax.persistence.EntityManager;

public final class QueryBuilderFactory {

    public static InsertQueryBuilder createInsertBuilder(String tableName, EntityManager entityManager)  {
        return new InsertQueryBuilderImpl(tableName, entityManager);
    }

}

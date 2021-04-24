package com.collectionart.app.collectionart.repositories.impl;

import com.collectionart.app.collectionart.operation.impl.ConvertMapOperator;
import com.collectionart.app.collectionart.repositories.HistoryRepository;
import com.collectionart.app.collectionart.utils.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

public class MapObjectHistoryRepository implements HistoryRepository<Map<String, Object>> {

    private final String tableName;

    private final EntityManager entityManager;

    private final Set<String> keys;

    private final Set<String> ignoreHistoryColumns;

    public MapObjectHistoryRepository(String tableName, EntityManager entityManager, Set<String> keys, Set<String>  ignoreHistoryColumns) {
        this.tableName = tableName;
        this.entityManager = entityManager;
        this.ignoreHistoryColumns = ignoreHistoryColumns;
        this.keys = keys;
    }

    protected Map<String, Object> createHistoryEntity(Map<String, Object> beforeHistory, Map<String, Object> afterHistory) {
                Iterator<String> keyIterator = keys.iterator();
        Map<String, Object> history = new HashMap<>();
        while (keyIterator.hasNext()) {
            String currentKey = keyIterator.next();
            setBeforeAfterColumn(history, currentKey, beforeHistory != null ? beforeHistory.get(currentKey) : null, afterHistory != null ? afterHistory.get(currentKey) : null);
        }
        return history;
    }

    private void setBeforeAfterColumn(Map<String, Object> history, String key, Object beforeValue, Object afterValue) {
        history.put(StringUtils.applyPrefix("before_", key), beforeValue);
        history.put(StringUtils.applyPrefix("after_", key), afterValue);
    }

    protected Query createQueryFrom(Map<String, Object> historyEntity) {
        Set<String> columns = historyEntity.keySet();

        StringBuilder insertHistorySqlBuilder = new StringBuilder("Insert into ")
            .append(this.tableName)
            .append("(")
            .append(String.join(", ", columns))
            .append(")")
            .append(" values ")
            .append(" (");

        for (int i = 0; i < columns.size(); i++) {
            insertHistorySqlBuilder
                    .append(i + 1)
                    .append("?");

            if(i > 0 || i < columns.size() - 1) {
                insertHistorySqlBuilder.append(", ");
            }
        }

        insertHistorySqlBuilder.append(")");

        return entityManager.createNativeQuery(insertHistorySqlBuilder.toString());
    }

    @Override
    public void insertHistory(Map<String, Object> beforeEntity, Map<String, Object> afterEntity) {
        final Map<String, Object> historyEntity = this.createHistoryEntity(beforeEntity, afterEntity);
        this.createQueryFrom(historyEntity).executeUpdate();
    }
}

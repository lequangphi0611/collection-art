package com.collectionart.app.collectionart.repositories.impl;

import com.collectionart.app.collectionart.common.provider.ProviderContainer;
import com.collectionart.app.collectionart.common.provider.impl.LazyProviderContainer;
import com.collectionart.app.collectionart.repositories.HistoryRepository;
import com.collectionart.app.collectionart.utils.CommonUtils;
import com.collectionart.app.collectionart.utils.StringUtils;
import com.collectionart.app.collectionart.utils.sqlutils.InsertQueryBuilder;
import com.collectionart.app.collectionart.utils.sqlutils.QueryBuilderFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

public abstract class MapObjectHistoryRepository implements HistoryRepository<Map<String, Object>> {

    private final String tableName;

    private final EntityManager entityManager;

    private final ProviderContainer<Set<String>> keysContainer;

    private final ProviderContainer<Set<String>> ignoreHístoryColumnsContainer;

    public MapObjectHistoryRepository(String tableName, EntityManager entityManager) {
        this.tableName = tableName;
        this.entityManager = entityManager;
        this.keysContainer = new LazyProviderContainer<>(this::initKeys);
        this.ignoreHístoryColumnsContainer = new LazyProviderContainer<>(this::initIgnoreColumns);
    }

    protected Set<String> initIgnoreColumns() {
        return Collections.emptySet();
    }

    protected abstract Set<String> initKeys();

    private Set<String> getKeys() {
        return keysContainer.get();
    }

    private Set<String> getIgnoreHístoryColumns() {
        return ignoreHístoryColumnsContainer.get();
    }


    private Query createHistoryQuery(Map<String, Object> beforeHistory, Map<String, Object> afterHistory) {
        InsertQueryBuilder insertQueryBuilder = QueryBuilderFactory
                .createInsertBuilder(this.tableName, this.entityManager);

//        Iterator<String> keyIterator = keys.iterator();
        Map<String, Object> before = Optional.ofNullable(beforeHistory).orElse(new HashMap<>());
        Map<String, Object> after = Optional.ofNullable(afterHistory).orElse(new HashMap<>());
//        while (keyIterator.hasNext()) {
//            String currentKey = keyIterator.next();
//            setBeforeAfterColumn(history, currentKey, before.get(currentKey), after.get(currentKey));
//        }
        getKeys().forEach((key) -> {
            if (getIgnoreHístoryColumns().contains(key)) {
                insertQueryBuilder.setColumn(key, after.get(key));
            } else {
                insertQueryBuilder.setColumn(StringUtils.applyPrefix("before_", key), before.get(key));
                insertQueryBuilder.setColumn(StringUtils.applyPrefix("after_", key), after.get(key));
            }

        });
        return insertQueryBuilder.build();
    }

    @Override
    public void insertHistory(Map<String, Object> entity) {
        this.doInsertHistory(null, entity);
    }

    @Override
    public void insertHistory(Map<String, Object> beforeEntity, Map<String, Object> afterEntity) {
        this.doInsertHistory(beforeEntity, afterEntity);
    }

    private void doInsertHistory(Map<String, Object> beforeEntity, Map<String, Object> afterEntity) {
        this.createHistoryQuery(beforeEntity, afterEntity).executeUpdate();
    }
}

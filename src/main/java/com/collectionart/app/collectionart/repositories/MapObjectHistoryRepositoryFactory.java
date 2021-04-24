package com.collectionart.app.collectionart.repositories;

import com.collectionart.app.collectionart.repositories.impl.MapObjectHistoryRepository;
import com.collectionart.app.collectionart.utils.ArrayUtils;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class MapObjectHistoryRepositoryFactory {

    public static HistoryRepository<Map<String, Object>> createMapObjectHistoryRepository(String tableName, EntityManager entityManager, Set<String> keys) {
        return createMapObjectHistoryRepository(tableName, entityManager, keys, Collections.emptySet());
    }

    public static HistoryRepository<Map<String, Object>> createMapObjectHistoryRepository(String tableName, EntityManager entityManager, Set<String> keys, Set<String> ignoreHistoryColumns) {
        return new MapObjectHistoryRepository(tableName, entityManager, keys, ignoreHistoryColumns);
    }

}

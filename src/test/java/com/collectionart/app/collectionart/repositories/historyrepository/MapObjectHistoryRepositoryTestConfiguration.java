package com.collectionart.app.collectionart.repositories.historyrepository;

import com.collectionart.app.collectionart.repositories.HistoryRepository;
import com.collectionart.app.collectionart.repositories.impl.MapObjectHistoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@TestConfiguration
public class MapObjectHistoryRepositoryTestConfiguration {

    @Bean
    @Qualifier("historyRepository")
    public HistoryRepository<Map<String, Object>> createHistoryRepository(EntityManager entityManager) {
        Set<String> keys = new HashSet<>();
        keys.add("id");
        keys.add("name");
        keys.add("age");
        keys.add("last_updated_time");
        keys.add("created_time");

        Set<String> ignoreColumns = new HashSet<>();
        ignoreColumns.add("id");
        ignoreColumns.add("last_updated_time");
        ignoreColumns.add("created_time");
        return new MapObjectHistoryRepository("test_history", entityManager,keys ,ignoreColumns);
    }

}

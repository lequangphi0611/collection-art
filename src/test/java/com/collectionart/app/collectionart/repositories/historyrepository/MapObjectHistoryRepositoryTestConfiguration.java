package com.collectionart.app.collectionart.repositories.historyrepository;

import com.collectionart.app.collectionart.mockers.EntityManagerMocker;
import com.collectionart.app.collectionart.mockers.QueryMocker;
import com.collectionart.app.collectionart.repositories.HistoryRepository;
import com.collectionart.app.collectionart.repositories.MapObjectHistoryRepositoryFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@TestConfiguration
public class MapObjectHistoryRepositoryTestConfiguration {

    @Bean
    @Qualifier("keys")
    public Set<String> createKeys() {
        Set<String> keys = new HashSet<>();
        keys.add("id");
        keys.add("user_id");
        keys.add("password");
        keys.add("created_date");
        keys.add("last_updated_date");
        keys.add("created_by");
        keys.add("last_updated_by");
        keys.add("age");
        return keys;
    };

    @Bean
    public Query createQuery() {
        return new QueryMocker();
    }

    @Bean
    public EntityManager createEntityManager(Query query) {
        return new EntityManagerMocker(query);
    }

    @Bean
    @Qualifier("historyRepositoryWithoutIgnoreHistoryColumns")
    public HistoryRepository<Map<String, Object>> createHistoryRepository(EntityManager entityManager, @Qualifier("keys") Set<String> keys) {
        return MapObjectHistoryRepositoryFactory.createMapObjectHistoryRepository("user_history", entityManager, keys);
    }

}

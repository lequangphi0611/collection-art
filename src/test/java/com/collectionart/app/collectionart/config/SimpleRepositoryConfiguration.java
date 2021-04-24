package com.collectionart.app.collectionart.config;

import com.collectionart.app.collectionart.entity.updatedTimeModel.TestBaseEntity;
import com.collectionart.app.collectionart.repositories.Repository;
import com.collectionart.app.collectionart.repositories.impl.SimpleRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@TestConfiguration
public class SimpleRepositoryConfiguration {

    @Bean(name = "SimpleRepository")
    public Repository<TestBaseEntity, String> createSimpleRepository(EntityManager entityManager) {
        return new SimpleRepository<TestBaseEntity, String>(entityManager, TestBaseEntity.class);
    }
}

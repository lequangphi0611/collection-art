package com.collectionart.app.collectionart.repositories.impl;

import com.collectionart.app.collectionart.entity.IdObject;
import com.collectionart.app.collectionart.repositories.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

public class SimpleRepository<E extends IdObject, ID extends Object> implements Repository<E, ID> {

    protected final EntityManager entityManager;

    protected final  Class<E> entityClass;

    public SimpleRepository(EntityManager entityManager, Class<E> entityClass) {
        this.entityManager= entityManager;
        this.entityClass = entityClass;
    }

    @Override
    public Optional<E> findById(ID id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }
}

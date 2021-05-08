package com.collectionart.app.collectionart.repositories;

public interface PersistRepository<T> {

    T persist(T entity);

}

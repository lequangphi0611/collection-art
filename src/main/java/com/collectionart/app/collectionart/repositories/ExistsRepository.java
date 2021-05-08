package com.collectionart.app.collectionart.repositories;

public interface ExistsRepository<E> {

    boolean exists(E entity);

}

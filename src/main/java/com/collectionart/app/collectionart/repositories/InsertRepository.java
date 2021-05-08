package com.collectionart.app.collectionart.repositories;

public interface InsertRepository<E> {

    <S extends E> S insert(S entity);

}

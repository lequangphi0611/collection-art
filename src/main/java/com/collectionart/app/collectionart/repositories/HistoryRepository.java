package com.collectionart.app.collectionart.repositories;

import com.collectionart.app.collectionart.entity.BaseEntity;
import com.collectionart.app.collectionart.entity.IdObject;

public interface HistoryRepository<S> {

    void insertHistory(S beforeEntity, S afterEntity);

    default void insertHistory(S entity) {
        this.insertHistory(null, entity);
    };

}

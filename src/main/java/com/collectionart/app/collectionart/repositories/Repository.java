package com.collectionart.app.collectionart.repositories;

import com.collectionart.app.collectionart.entity.IdObject;

import java.util.Optional;

public interface Repository<E extends IdObject, ID> {

    Optional<E> findById(ID id);

}

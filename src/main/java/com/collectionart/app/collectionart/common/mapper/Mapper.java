package com.collectionart.app.collectionart.common.mapper;

public interface Mapper<T, E> {

    T accept(E obs);

}

package com.collectionart.app.collectionart.operation;

public interface Operator<T, S> {

    S apply(T target);

}

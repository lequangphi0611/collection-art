package com.collectionart.app.collectionart.common.interceptor;

public interface Interceptor<T> {

    T apply(T target);

}

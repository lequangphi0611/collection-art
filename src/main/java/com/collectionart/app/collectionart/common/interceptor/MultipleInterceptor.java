package com.collectionart.app.collectionart.common.interceptor;

public interface MultipleInterceptor<T> extends Interceptor<T> {

    MultipleInterceptor<T> addInterceptor(Interceptor<T> interceptor);

}

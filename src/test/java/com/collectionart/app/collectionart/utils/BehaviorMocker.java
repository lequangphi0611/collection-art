package com.collectionart.app.collectionart.utils;

public interface BehaviorMocker extends Resettable {
    MethodMocker get(String methodName);

    void reset();

    void reset(String methodName);
}

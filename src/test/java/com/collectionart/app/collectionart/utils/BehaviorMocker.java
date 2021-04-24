package com.collectionart.app.collectionart.utils;

public interface BehaviorMocker {
    MethodMocker get(String methodName);

    void resetAll();

    void reset(String methodName);
}

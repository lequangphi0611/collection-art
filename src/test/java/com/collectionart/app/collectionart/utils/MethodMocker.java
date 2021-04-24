package com.collectionart.app.collectionart.utils;

import java.util.Stack;

public interface MethodMocker {

    int getCalledTime();

    Object[] getLastCallWith();

    Iterable<Object[]> callWithIterator();

    boolean isCalled();

    void reset();
}
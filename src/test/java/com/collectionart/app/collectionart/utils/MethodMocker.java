package com.collectionart.app.collectionart.utils;

import java.util.Iterator;
import java.util.Stack;

public interface MethodMocker extends Resettable {

    String getMethodName();

    int getCalledTime();

    Object[] getLastCallWith();

    Iterator<Object[]> callWithIterator();

    boolean isCalled();

}
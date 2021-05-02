package com.collectionart.app.collectionart.utils;

import org.assertj.core.util.Arrays;

import java.util.*;

public class SimpleMethodMocker implements MethodMocker {

    public static final Object[] NO_ARGS = new String[]{"NO_ARGS"};

    private int calledTime = 0;

    private List<Object[]> paramsCalled;

    private final String methodName;

    public SimpleMethodMocker(final String methodName) {
        this.paramsCalled = new ArrayList<>();
        this.methodName = methodName;
    }

    protected void call(Object... args) {
        this.calledTime++;
        this.paramsCalled.add(args.length == 0 ? NO_ARGS : args);
    }

    @Override
    public int getCalledTime() {
        return this.calledTime;
    }

    @Override
    public boolean isCalled() {
        return calledTime > 0;
    }

    @Override
    public void reset() {
        this.calledTime = 0;
        this.paramsCalled.clear();
    }

    @Override
    public Object[] getLastCallWith() {
        if(isCalled()) {
            return CollectionUtils.last(this.paramsCalled);
        }

        throw new MethodWasNotCallException("Method was not called !");
    }

    @Override
    public Iterator<Object[]> callWithIterator() {
        if(isCalled()) {
            return this.paramsCalled.iterator();
        }

        throw new MethodWasNotCallException("Method was not called !");
    }

    @Override
    public String getMethodName() {
        return this.methodName;
    }

}

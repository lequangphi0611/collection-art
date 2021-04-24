package com.collectionart.app.collectionart.utils;

import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SimpleMethodMocker implements MethodMocker {

    public static final Object[] NO_ARGS = new String[]{"NO_ARGS"};

    private int calledTime = 0;

    private List<Object[]> paramsCalled;

    public SimpleMethodMocker() {
        this.paramsCalled = new ArrayList<>();
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
    public Iterable<Object[]> callWithIterator() {
        if(isCalled()) {
            return (Iterable<Object[]>) this.paramsCalled.iterator();
        }

        throw new MethodWasNotCallException("Method was not called !");
    }

}

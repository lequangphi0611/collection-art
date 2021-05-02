package com.collectionart.app.collectionart.utils;

import java.util.ArrayList;
import java.util.List;

public class SimpleResettableManager implements ResettableManager {

    List<Resettable> resettableList;

    public SimpleResettableManager() {
        this.resettableList = new ArrayList<>();
    }

    @Override
    public void reset() {
        resettableList.forEach(Resettable::reset);
    }

    @Override
    public ResettableManager add(Resettable resettable) {
        this.resettableList.add(resettable);
        return this;
    }
}

package com.collectionart.app.collectionart.common.provider.impl;

import com.collectionart.app.collectionart.common.provider.InstanceCreator;
import com.collectionart.app.collectionart.common.provider.ProviderContainer;

public class LazyProviderContainer<P> implements ProviderContainer<P> {

    private P instance;

    private final InstanceCreator<P> instanceCreator;

    public LazyProviderContainer(InstanceCreator<P> instanceCreator) {
        this.instanceCreator = instanceCreator;
    }

    @Override
    public P get() {
        if(instance == null) {
            instance = instanceCreator.createInstance();
        }
        return instance;
    }
}

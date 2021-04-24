package com.collectionart.app.collectionart.utils;

public class MockerUtil {

    public static BehaviorMocker castBehaviorMocker(Object ob) {
        if(ob instanceof BehaviorMocker) {
            return (BehaviorMocker) ob;
        }

        throw new RuntimeException(ob.getClass().getName() + " is not a BehaviorMocker");
    }
}

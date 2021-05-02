package com.collectionart.app.collectionart.utils;

import com.collectionart.app.collectionart.common.ArgumentInCorrectException;

import java.util.Collection;

public final class CommonUtils {

    public static void require(String argName, Object arg) {
        if(arg == null) {
            throw new ArgumentInCorrectException(argName + " is required!");
        }
    }

}

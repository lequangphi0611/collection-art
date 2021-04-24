package com.collectionart.app.collectionart.utils;

public class MethodWasNotCallException extends Error {

    public MethodWasNotCallException(String message) {
        super(message);
    }

    public MethodWasNotCallException(Throwable throwable) {
        super(throwable);
    }

}

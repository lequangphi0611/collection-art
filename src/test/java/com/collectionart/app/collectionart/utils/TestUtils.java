package com.collectionart.app.collectionart.utils;

import com.mysql.cj.exceptions.AssertionFailedException;
import org.junit.ComparisonFailure;
import org.junit.jupiter.api.Assertions;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public final class TestUtils extends Assertions {

    public static void assertDeepEquals(Object expected, Object actual) {
        if(!Objects.deepEquals(expected, actual)) {
            throw new AssertionFailedError("Not equals", expected, actual);
        }
    }

    public static void assertDeepEquals(Object[] actual, Object[] expected) {
        for(int index = 0; index < expected.length; index++) {
            assertDeepEquals(expected[index], actual[index]);
        }
    }

    public static void assertLastCallWiths(MethodMocker mocker, Object... expected) {
        Object[] actual = mocker.getLastCallWith();
        assertDeepEquals(expected, actual);
    }

    public static void assertCallTime(MethodMocker mocker, int time) {
        if(time != mocker.getCalledTime()) {
            throw new AssertionFailedError("Method [" + mocker.getMethodName() + "] call with " + mocker.getCalledTime() + " not be " + time, time, mocker.getCalledTime());
        }
    }

    public static void assertLength(CharSequence charSequence, int length) {
        if(charSequence.length() != length) {
            throw new AssertionFailedError("Length should be " + length, length, charSequence.length());
        }
    }

}

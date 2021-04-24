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

    public static <E> void assertEmpty(Collection<E> collection) {
        if(collection == null || !collection.isEmpty()) {
            throw new ComparisonFailure("Must be empty", "size = 0", collection == null ? null : "size= " + collection.size());
        }
    }

    public static <T> void assertEmpty(Optional<T> optional) {
        if(optional == null || optional.isPresent()) {
            throw new ComparisonFailure("Must be empty", "Optional.empty", optional == null ? null  : optional.toString());
        }
    }

    public static void assertDeepEquals(Object[] expected, Object[] actual) {
        for(int index = 0; index < expected.length; index++) {
            if(!Objects.deepEquals(actual[index], expected[index])) {
                throw new AssertionFailedError("Not equals", Arrays.toString(expected), Arrays.toString(actual));
            }
        }
    }

    public static void assertLastCallWiths(MethodMocker mocker, Object... expected) {
        Object[] actual = mocker.getLastCallWith();
        assertDeepEquals(expected, actual);
    }

}

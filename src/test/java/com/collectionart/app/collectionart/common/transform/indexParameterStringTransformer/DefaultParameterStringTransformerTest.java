package com.collectionart.app.collectionart.common.transform.indexParameterStringTransformer;

import com.collectionart.app.collectionart.common.transform.ParameterStringTransformer;
import com.collectionart.app.collectionart.common.transform.impl.DefaultParameterStringTransformer;
import com.collectionart.app.collectionart.utils.CollectionUtils;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultParameterStringTransformerTest {

    private ParameterStringTransformer parameterStringTransformer;

    @Before
    public void setUp() {
        parameterStringTransformer = new DefaultParameterStringTransformer();
    }

    @Test
    public void testNonSetParameter() {
        final String input = "Non set parameter case";
        final String actual = parameterStringTransformer.transform(input);
        TestUtils.assertEquals(input, actual);
    }

    @Test
    public void testSetOneParameter() {
        final String input = "{0} parameter, {1} parameter, {2} parameter";
        final String actual = parameterStringTransformer
                .setParameter(0,"first")
                .transform(input);
        final String expected = "first parameter, {1} parameter, {2} parameter";
        TestUtils.assertEquals(expected, actual);
    }

    @Test
    public void testSetManyParameter() {
        final String input = "{0} parameter, {1} parameter, {2} parameter";
        final String actual = parameterStringTransformer
                .setParameter(0, "first")
                .setParameter(1, "second")
                .setParameter(2, "third")
                .transform(input);
        final String expected = "first parameter, second parameter, third parameter";
        TestUtils.assertEquals(expected, actual);
    }

    @Test
    public void testSetNullParameter() {
        final String input = "Parameter is {null}";
        final String actual = parameterStringTransformer
                .setParameter("null", null)
                .transform(input);
        final String expected = "Parameter is null";
        TestUtils.assertEquals(expected, actual);
    }

//    @Test
//    @SuppressWarnings({"unchecked"})
//    public void testNonCallReduceWhenParameterNotValid() {
//        AtomicInteger reduceLoopCall = new AtomicInteger();
//
//        final String input = "Parameter is {0}";
//        final String actual = parameterStringTransformer
//                .setParameter(1, null)
//                .transform(input);
////        final String expected = "Parameter is {0}";
////        TestUtils.assertEquals(expected, actual);
//        TestUtils.assertEquals(0, reduceLoopCall.get());
//    }

}

package com.collectionart.app.collectionart.utilstest.collectionsutil;

import com.collectionart.app.collectionart.utils.CollectionUtils;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionUtilsLastTest {

    @Test
    public void testLastMethods() {
        Collection<String> collection = Arrays.asList("A", "B", "C");
        TestUtils.assertEquals("C", CollectionUtils.last(collection));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionWhenNotHaveElement() {
        CollectionUtils.last(new ArrayList<>());
    }

}

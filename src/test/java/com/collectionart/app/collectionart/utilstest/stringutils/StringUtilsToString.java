package com.collectionart.app.collectionart.utilstest.stringutils;

import com.collectionart.app.collectionart.utils.StringUtils;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Test;

public class StringUtilsToString {

    @Test
    public void testToStringWithNull() {
        TestUtils.assertEquals("null", StringUtils.toString(null));
    }

    @Test
    public void testToStringWithString() {
        TestUtils.assertEquals("string", StringUtils.toString("string"));
    }

    @Test
    public void testToStringWithObject() {
        TestUtils.assertEquals("string builder", StringUtils.toString(new StringBuilder("string builder")));
    }


}

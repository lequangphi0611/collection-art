package com.collectionart.app.collectionart.utilstest.stringutils;

import com.collectionart.app.collectionart.utils.StringUtils;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Test;

public class StringUtilsApplyPrefixTest {

    @Test
    public void testApplyPrefixWithString() {
        final String prefix = "prefix - ";
        final String target = "target";

        TestUtils.assertEquals("prefix - target", StringUtils.applyPrefix(prefix, target));
    }

    @Test
    public void testApplyPrefixWithStringBuilder() {
        final StringBuilder prefix = new StringBuilder("prefix - ");
        final StringBuilder target = new StringBuilder("target").append(" string builder");

        TestUtils.assertEquals("prefix - target string builder", StringUtils.applyPrefix(prefix, target));
    }

    @Test
    public void testApplyPrefixWithStringBuffer() {
        final StringBuffer prefix = new StringBuffer("prefix - ").append("string buffer - ");
        final StringBuffer target = new StringBuffer("target");

        TestUtils.assertEquals("prefix - string buffer - target", StringUtils.applyPrefix(prefix, target));
    }

}

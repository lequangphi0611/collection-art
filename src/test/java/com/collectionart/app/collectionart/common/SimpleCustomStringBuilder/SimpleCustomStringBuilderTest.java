package com.collectionart.app.collectionart.common.SimpleCustomStringBuilder;

import com.collectionart.app.collectionart.common.CustomStringBuilder;
import com.collectionart.app.collectionart.common.impl.SimpleCustomStringBuilder;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

public class SimpleCustomStringBuilderTest {

    private CustomStringBuilder customStringBuilder;

    @Before
    public void setUp() {
        this.customStringBuilder = new SimpleCustomStringBuilder();
    }

    @Test
    public void testAppendMethod() {
        customStringBuilder.append("Start Builder");
        TestUtils.assertEquals("Start Builder", customStringBuilder.toString());
    }

    @Test
    public void testAppendCallManyTime() {
        customStringBuilder.append("Start Builder");
        customStringBuilder.append(" Start Builder 2");
        customStringBuilder.append("\n");
        customStringBuilder.append("end");
        TestUtils.assertEquals("Start Builder Start Builder 2\nend", customStringBuilder.toString());
    }

    @Test
    public void testAppendWithIndex() {
        customStringBuilder.append("append with offset");
        customStringBuilder.append("11", 0, 2);
        TestUtils.assertEquals("append with offset11", customStringBuilder.toString());
    }

    @Test
    public void testAppendWithChar() {
        char ch = 'a';
        customStringBuilder.append(ch);
        TestUtils.assertEquals("a", customStringBuilder.toString());
    }

    @Test
    public void testLength() {
        customStringBuilder.append("2222");
        TestUtils.assertLength(customStringBuilder, 4);
    }

    @Test
    public void testCharAt() {
        customStringBuilder.append("2232");
        TestUtils.assertEquals('3', customStringBuilder.charAt(2));
    }

    @Test
    public void testSubStrs() {
        customStringBuilder.append("SubString test");
        TestUtils.assertEquals("test", customStringBuilder.subSequence(10, 14));
    }

    @Test
    public void testAppendComma() {
        customStringBuilder.appendComma();
        TestUtils.assertEquals(",", customStringBuilder.toString());
    }

    @Test
    public void testAppendSpace() {
        customStringBuilder.appendSpace();
        TestUtils.assertEquals(" ", customStringBuilder.toString());
    }

    @Test
    public void testAppendInteger() {
        customStringBuilder.append(1);
        TestUtils.assertEquals("1", customStringBuilder.toString());
    }

    @Test
    public void testAppendQuestionMask() {
        customStringBuilder.appendQuestionMask();
        TestUtils.assertEquals("?", customStringBuilder.toString());
    }

    @Test
    public void testInsert() {
        CustomStringBuilder customStringBuilder = new SimpleCustomStringBuilder("inserted");
        customStringBuilder.insert(0, "Should be ");
        TestUtils.assertEquals("Should be inserted", customStringBuilder.toString());
    }

    @Test
    public void testWrapParenthesis() {
        CustomStringBuilder customStringBuilder = new SimpleCustomStringBuilder("wrap parenthesis");
        customStringBuilder.wrapParenthesis();
        TestUtils.assertEquals("(wrap parenthesis)", customStringBuilder.toString());
    }

}

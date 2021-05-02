package com.collectionart.app.collectionart.utilstest.commonutils;

import com.collectionart.app.collectionart.common.ArgumentInCorrectException;
import com.collectionart.app.collectionart.utils.ArrayUtils;
import com.collectionart.app.collectionart.utils.CommonUtils;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.assertj.core.util.Arrays;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

public class CommonUtilsTest {

    @Test
    public void testRequireWithNonValid() {
        String field = null;
        try {
            CommonUtils.require("field", field);
            TestUtils.fail("Not throw exception");
        } catch (ArgumentInCorrectException e) {
            TestUtils.assertEquals("field is required!", e.getMessage());
        }
    }

    @Test
    public void testRequireMethodWithValid() {
        String field = "";
        CommonUtils.require("field", field);
    }

}

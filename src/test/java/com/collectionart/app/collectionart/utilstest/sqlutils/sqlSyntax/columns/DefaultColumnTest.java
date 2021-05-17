package com.collectionart.app.collectionart.utilstest.sqlutils.sqlSyntax.columns;

import com.collectionart.app.collectionart.utils.TestUtils;
import com.collectionart.app.collectionart.utils.sqlutils.sql_syntax.column.Column;
import com.collectionart.app.collectionart.utils.sqlutils.sql_syntax.column.impl.DefaultColumn;
import org.junit.Test;

public class DefaultColumnTest {

    private static final String COLUMN_NAME = "userName";

    @Test
    public void testWithoutAlias() {
        Column column = new DefaultColumn(COLUMN_NAME);
        TestUtils.assertEquals("userName", column.toSQL());
    }

}

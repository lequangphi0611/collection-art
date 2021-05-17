package com.collectionart.app.collectionart.utils.sqlutils.sql_syntax.column.impl;

import com.collectionart.app.collectionart.common.CustomStringBuilder;
import com.collectionart.app.collectionart.common.impl.SimpleCustomStringBuilder;
import com.collectionart.app.collectionart.utils.sqlutils.SqlConstants;
import com.collectionart.app.collectionart.utils.sqlutils.sql_syntax.SqlSyntax;
import com.collectionart.app.collectionart.utils.sqlutils.sql_syntax.column.Column;
import lombok.Value;

@Value
public class DefaultColumn implements Column {

    String name;

    @Override
    public String toSQL() {
        return this.name;
    }

}

package com.collectionart.app.collectionart.utils.sqlutils.sql_syntax.column.impl;

import com.collectionart.app.collectionart.common.CustomStringBuilder;
import com.collectionart.app.collectionart.common.impl.SimpleCustomStringBuilder;
import com.collectionart.app.collectionart.utils.sqlutils.SqlConstants;
import com.collectionart.app.collectionart.utils.sqlutils.sql_syntax.column.Column;
import com.collectionart.app.collectionart.utils.sqlutils.sql_syntax.column.SelectColumn;

public class SimpleSelectColumn extends DefaultColumn implements SelectColumn {

    protected String aliasName;

    public SimpleSelectColumn(final String name) {
        super(name);
    }

    private void appendAlias(CustomStringBuilder builder) {
        builder.appendSpace()
                .append(SqlConstants.ALIAS)
                .appendSpace()
                .append(this.aliasName);
    }

    protected CustomStringBuilder computeName() {
        return new SimpleCustomStringBuilder(this.name);
    }

    @Override
    public String toSQL() {
        CustomStringBuilder sqlSyntax = this.computeName();
        if (this.aliasName != null) {
            this.appendAlias(sqlSyntax);
        }
        return sqlSyntax.toString();
    }

    @Override
    public Column as(String aliasName) {
        this.aliasName = aliasName;
        return this;
    }
}

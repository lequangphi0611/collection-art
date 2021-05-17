package com.collectionart.app.collectionart.utils.sqlutils.sql_syntax.column;

public interface SelectColumn extends Column {

    Column as(String aliasName);

}

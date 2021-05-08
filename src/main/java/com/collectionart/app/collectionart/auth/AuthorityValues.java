package com.collectionart.app.collectionart.auth;

import lombok.ToString;

@ToString
public enum AuthorityValues implements Authority {

    CREATE_EMPLOYEE("C_EMPLOYEE"),

    READ_EMPLOYEE("R_EMPLOYEE"),

    DELETE_EMPLOYEE("D_EMPLOYEE"),

    FULL_AUTHORITY("FULL_AUTH")

    ;

    private final String name;

    AuthorityValues(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

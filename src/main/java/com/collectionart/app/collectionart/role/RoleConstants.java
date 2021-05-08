package com.collectionart.app.collectionart.role;

public final class RoleConstants {

    public final static String ENTITY_TABLE_NAME = "role";

    public final static String JOIN_TABLE_AUTHORITIES_TABLE_NAME = "role_authority";

    public final static String JOIN_TABLE_AUTHORITIES_JOIN_COLUMN = "role_id";

    public final static String JOIN_TABLE_AUTHORITIES_INVERSE_COLUMN = "authority_name";

    public final static String JOIN_TABLE_USERS_MAPPED_BY = "roles";

}

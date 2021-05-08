package com.collectionart.app.collectionart.auth;

import com.collectionart.app.collectionart.auth.mappers.AuthorityEntityMapper;
import com.collectionart.app.collectionart.common.mapper.Mapper;

public final class AuthorityFactory {

    public static AuthorityEntity createAuthorityEntity(String name) {
        AuthorityEntity entity = new AuthorityEntity();
        entity.setName(name);
        return entity;
    }

    public static Mapper<AuthorityEntity, Authority> getAuthorityMapper() {
        return new AuthorityEntityMapper();
    }

}

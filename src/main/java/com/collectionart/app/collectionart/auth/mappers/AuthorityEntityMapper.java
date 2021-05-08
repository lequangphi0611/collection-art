package com.collectionart.app.collectionart.auth.mappers;

import com.collectionart.app.collectionart.auth.Authority;
import com.collectionart.app.collectionart.auth.AuthorityEntity;
import com.collectionart.app.collectionart.auth.AuthorityFactory;
import com.collectionart.app.collectionart.auth.AuthorityValues;
import com.collectionart.app.collectionart.common.mapper.Mapper;

public class AuthorityEntityMapper implements Mapper<AuthorityEntity, Authority> {
    @Override
    public AuthorityEntity accept(Authority obs) {
        return AuthorityFactory.createAuthorityEntity(obs.getName());
    }
}

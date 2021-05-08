package com.collectionart.app.collectionart.entity.auth;

import com.collectionart.app.collectionart.auth.*;
import com.collectionart.app.collectionart.common.mapper.Mapper;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Test;

public class AuthorityEntityMapperTest {

    private final Mapper<AuthorityEntity, Authority> authorityEntityMapper = AuthorityFactory.getAuthorityMapper();

    @Test
    public void testMapWithAuthorityValues() {
        AuthorityEntity result = authorityEntityMapper.accept(AuthorityValues.FULL_AUTHORITY);
        AuthorityEntity entity = AuthorityFactory.createAuthorityEntity("FULL_AUTH");
        TestUtils.assertDeepEquals(entity, result);
    }

}

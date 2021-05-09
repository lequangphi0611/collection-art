package com.collectionart.app.collectionart.user.repositories;

import com.collectionart.app.collectionart.common.mapper.Mapper;
import com.collectionart.app.collectionart.user.UserEntity;

public interface FindUserByUsernameOrEmailRepository {

    UserEntity findByUsernameOrEmail(String usernameOrEmail);

    <T> T findByUsernameOrEmail(String usernameOrEmail, Mapper<T, UserEntity> mapper);

}

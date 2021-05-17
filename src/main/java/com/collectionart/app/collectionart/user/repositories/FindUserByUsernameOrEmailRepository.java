package com.collectionart.app.collectionart.user.repositories;

import com.collectionart.app.collectionart.user.User;

import java.util.Optional;

public interface FindUserByUsernameOrEmailRepository {

    <S extends User> Optional<S> findByUsernameOrEmail(String username, String email);

}

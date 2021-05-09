package com.collectionart.app.collectionart.user.services;

import com.collectionart.app.collectionart.user.UserAccount;

public interface UserService {

    <S extends UserAccount> S findByUserNameOrEmail(String usernameOrEmail);

}

package com.collectionart.app.collectionart.user;

import com.collectionart.app.collectionart.email.EmailAble;

import java.time.LocalDate;

public interface BaseUserInfo extends EmailAble {

    String getFirstName();

    String getLastName();

    LocalDate getBirthDay();

    String getAvatar();

}

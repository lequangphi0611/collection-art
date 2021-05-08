package com.collectionart.app.collectionart.user;

import com.collectionart.app.collectionart.email.EmailAble;

import java.time.LocalDate;

public interface BaseUserInfo extends EmailAble {

    String getFistName();

    String getLastName();

    LocalDate getBirthDay();

    Avatar getAvatar();

}

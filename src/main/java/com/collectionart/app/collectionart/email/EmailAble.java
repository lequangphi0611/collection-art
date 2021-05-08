package com.collectionart.app.collectionart.email;

public interface EmailAble {

    <S extends Email> S getEmail();

}

package com.collectionart.app.collectionart.auth;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthorityEntity implements IAuthority {

    @Id
    private String code;

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}

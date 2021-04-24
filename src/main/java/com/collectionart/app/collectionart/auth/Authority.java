package com.collectionart.app.collectionart.auth;

public enum Authority implements IAuthority {

    EMPLOY_MODIFY("E_M"),

    EMPLOY_READ("E_R");

    private final String code;

    Authority(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}

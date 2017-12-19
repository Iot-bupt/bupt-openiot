package com.bupt.openiot.model;

/**
 * 用来存储登录到OpenIoT平台时，OpenIoT平台所返回的accessToken和refreshToken
 * Created by dy on 2017/6/5.
 */
public class LoginToken {

    private String token;

    private String refreshToken;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}

package com.bupt.openiot.common.data.security;

/**
 * Created by dy on 2017/5/1.
 */
public class DeviceTokenCredentials implements DeviceCredentialsFilter {

    private final String token;

    public DeviceTokenCredentials(String token) {
        this.token = token;
    }

    @Override
    public DeviceCredentialsType getCredentialsType() {
        return DeviceCredentialsType.ACCESS_TOKEN;
    }

    @Override
    public String getCredentialsId() {
        return token;
    }

    @Override
    public String toString() {
        return "DeviceTokenCredentials [token=" + token + "]";
    }
}

package com.bupt.openiot.common.data.security;

/**
 * Created by dy on 2017/5/1.
 */
public interface DeviceCredentialsFilter {

    String getCredentialsId();

    DeviceCredentialsType getCredentialsType();
}

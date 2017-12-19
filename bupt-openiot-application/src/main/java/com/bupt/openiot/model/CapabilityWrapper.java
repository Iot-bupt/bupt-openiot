package com.bupt.openiot.model;

import com.bupt.openiot.dao.model.Capability;

/**
 * Created by dy on 2017/5/25.
 */
public class CapabilityWrapper extends Capability {

    private String deviceName;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}

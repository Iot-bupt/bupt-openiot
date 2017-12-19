package com.bupt.openiot.model;

import com.bupt.openiot.dao.model.DeviceGroup;

/**
 * Created by dy on 2017/5/14.
 */
public class DeviceGroupWrapper extends DeviceGroup {

    private Integer deviceCount;

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }
}

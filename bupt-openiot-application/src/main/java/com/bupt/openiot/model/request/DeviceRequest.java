package com.bupt.openiot.model.request;

/**
 * Created by dy on 2017/5/14.
 */
public class DeviceRequest {

    private String name;
    private String description;
    private String devicegroup;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDevicegroup() {
        return devicegroup;
    }

    public void setDevicegroup(String devicegroup) {
        this.devicegroup = devicegroup;
    }

    @Override
    public String toString() {
        return "DeviceRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", devicegroup='" + devicegroup + '\'' +
                '}';
    }
}

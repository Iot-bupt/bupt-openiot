package com.bupt.openiot.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "device_bind_group")
public class DeviceBindGroup {
    @Id
    @Column(name = "deviceId")
    private String deviceid;

    @Id
    @Column(name = "devicegroupId")
    private String devicegroupid;

    /**
     * @return deviceId
     */
    public String getDeviceid() {
        return deviceid;
    }

    /**
     * @param deviceid
     */
    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    /**
     * @return devicegroupId
     */
    public String getDevicegroupid() {
        return devicegroupid;
    }

    /**
     * @param devicegroupid
     */
    public void setDevicegroupid(String devicegroupid) {
        this.devicegroupid = devicegroupid;
    }
}
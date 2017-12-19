package com.bupt.openiot.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Device {
    @Id
    private Integer id;

    @Id
    @Column(name = "deviceId")
    private String deviceid;

    private String name;

    private String status;

    private Date lasttime;

    private String description;

    private String protocol;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return lasttime
     */
    public Date getLasttime() {
        return lasttime;
    }

    /**
     * @param lasttime
     */
    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * @param protocol
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
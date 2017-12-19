package com.bupt.openiot.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Capability {
    @Id
    private Long id;

    @Id
    @Column(name = "capabilityId")
    private String capabilityid;

    @Column(name = "deviceId")
    private String deviceid;

    private String name;

    private String description;

    private String status;

    private Long cost;

    private Long type;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return capabilityId
     */
    public String getCapabilityid() {
        return capabilityid;
    }

    /**
     * @param capabilityid
     */
    public void setCapabilityid(String capabilityid) {
        this.capabilityid = capabilityid;
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
     * @return cost
     */
    public Long getCost() {
        return cost;
    }

    /**
     * @param cost
     */
    public void setCost(Long cost) {
        this.cost = cost;
    }

    /**
     * @return type
     */
    public Long getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Long type) {
        this.type = type;
    }
}
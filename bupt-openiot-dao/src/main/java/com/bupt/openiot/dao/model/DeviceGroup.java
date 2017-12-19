package com.bupt.openiot.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "device_group")
public class DeviceGroup {
    @Id
    private Integer id;

    @Id
    @Column(name = "devicegroupId")
    private String devicegroupid;

    @Id
    private String path;

    private String description;

    private Date createtime;

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

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
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
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
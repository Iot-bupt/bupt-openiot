package com.bupt.openiot.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "com_method")
public class ComMethod {
    @Id
    private Long id;

    @Id
    @Column(name = "com_method_id")
    private String comMethodId;

    @Column(name = "com_method")
    private String comMethod;

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
     * @return com_method_id
     */
    public String getComMethodId() {
        return comMethodId;
    }

    /**
     * @param comMethodId
     */
    public void setComMethodId(String comMethodId) {
        this.comMethodId = comMethodId;
    }

    /**
     * @return com_method
     */
    public String getComMethod() {
        return comMethod;
    }

    /**
     * @param comMethod
     */
    public void setComMethod(String comMethod) {
        this.comMethod = comMethod;
    }

}
package com.bupt.openiot.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "parameter_type")
public class ParameterType {
    @Id
    private Long id;

    @Id
    @Column(name = "parameter_type_id")
    private String parameterTypeId;

    @Column(name = "parameter_type")
    private String parameterType;

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
     * @return parameter_type_id
     */
    public String getParameterTypeId() {
        return parameterTypeId;
    }

    /**
     * @param parameterTypeId
     */
    public void setParameterTypeId(String parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }

    /**
     * @return parameter_type
     */
    public String getParameterType() {
        return parameterType;
    }

    /**
     * @param parameterType
     */
    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }
}
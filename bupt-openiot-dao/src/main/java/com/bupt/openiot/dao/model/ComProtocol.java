package com.bupt.openiot.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "com_protocol")
public class ComProtocol {
    @Id
    private Long id;

    @Id
    @Column(name = "com_protocol_id")
    private String comProtocolId;

    @Column(name = "com_protocol")
    private String comProtocol;

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
     * @return com_protocol_id
     */
    public String getComProtocolId() {
        return comProtocolId;
    }

    /**
     * @param comProtocolId
     */
    public void setComProtocolId(String comProtocolId) {
        this.comProtocolId = comProtocolId;
    }

    /**
     * @return com_protocol
     */
    public String getComProtocol() {
        return comProtocol;
    }

    /**
     * @param comProtocol
     */
    public void setComProtocol(String comProtocol) {
        this.comProtocol = comProtocol;
    }
}
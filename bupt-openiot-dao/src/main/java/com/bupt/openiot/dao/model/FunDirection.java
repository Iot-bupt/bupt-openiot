package com.bupt.openiot.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "fun_direction")
public class FunDirection {
    @Id
    private Long id;

    @Id
    @Column(name = "fun_direction_id")
    private String funDirectionId;

    @Column(name = "fun_direction")
    private String funDirection;

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
     * @return fun_direction_id
     */
    public String getFunDirectionId() {
        return funDirectionId;
    }

    /**
     * @param funDirectionId
     */
    public void setFunDirectionId(String funDirectionId) {
        this.funDirectionId = funDirectionId;
    }

    /**
     * @return fun_direction
     */
    public String getFunDirection() {
        return funDirection;
    }

    /**
     * @param funDirection
     */
    public void setFunDirection(String funDirection) {
        this.funDirection = funDirection;
    }
}
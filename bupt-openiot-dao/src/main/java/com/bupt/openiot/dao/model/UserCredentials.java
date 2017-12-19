package com.bupt.openiot.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user_credentials")
public class UserCredentials {
    /**
     * timeuuid
     */
    @Id
    private String id;

    /**
     * timeuuid
     */
    @Column(name = "user_id")
    private String userId;

    private Boolean enabled;

    private String password;

    @Column(name = "activate_token")
    private String activateToken;

    @Column(name = "reset_token")
    private String resetToken;

    /**
     * timeuuid
     *
     * @return id - timeuuid
     */
    public String getId() {
        return id;
    }

    /**
     * timeuuid
     *
     * @param id timeuuid
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * timeuuid
     *
     * @return user_id - timeuuid
     */
    public String getUserId() {
        return userId;
    }

    /**
     * timeuuid
     *
     * @param userId timeuuid
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return activate_token
     */
    public String getActivateToken() {
        return activateToken;
    }

    /**
     * @param activateToken
     */
    public void setActivateToken(String activateToken) {
        this.activateToken = activateToken;
    }

    /**
     * @return reset_token
     */
    public String getResetToken() {
        return resetToken;
    }

    /**
     * @param resetToken
     */
    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }
}
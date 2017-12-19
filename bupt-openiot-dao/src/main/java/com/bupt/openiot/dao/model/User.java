package com.bupt.openiot.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class User {
    /**
     * timeuuid
     */
    @Id
    private String id;

    /**
     * timeuuid
     */
    @Id
    @Column(name = "tenant_id")
    private String tenantId;

    /**
     * timeuuid
     */
    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Id
    private String authority;

    private String email;

    @Column(name = "search_text")
    private String searchText;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "additional_info")
    private String additionalInfo;

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
     * @return tenant_id - timeuuid
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * timeuuid
     *
     * @param tenantId timeuuid
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * timeuuid
     *
     * @return customer_id - timeuuid
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * timeuuid
     *
     * @param customerId timeuuid
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * @param authority
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return search_text
     */
    public String getSearchText() {
        return searchText;
    }

    /**
     * @param searchText
     */
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    /**
     * @return first_name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return last_name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return additional_info
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * @param additionalInfo
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
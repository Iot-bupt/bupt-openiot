package com.bupt.openiot.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Tenant {
    /**
     * timeuuid
     */
    @Id
    private String id;

    @Id
    private String region;

    private String title;

    @Column(name = "search_text")
    private String searchText;

    private String country;

    private String state;

    private String city;

    private String address;

    private String address2;

    private String zip;

    private String phone;

    private String email;

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
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
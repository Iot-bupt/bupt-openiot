package com.bupt.openiot.model;

import java.util.List;

/**
 * Created by dy on 2017/5/25.
 */
public class CapabilityList {

    private Long id;
    private String name;
    private List<CapabilityWrapper> capabilityWrapperList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CapabilityWrapper> getCapabilityWrapperList() {
        return capabilityWrapperList;
    }

    public void setCapabilityWrapperList(List<CapabilityWrapper> capabilityWrapperList) {
        this.capabilityWrapperList = capabilityWrapperList;
    }
}

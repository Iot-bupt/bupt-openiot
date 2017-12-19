package com.bupt.openiot.dao.capability;

import com.bupt.openiot.dao.model.Capability;

import java.util.List;

/**
 * Created by dy on 2017/5/24.
 */
public interface CapabilityService {

    public List<Capability> getByDeviceId(String deviceId);

    public Capability getByCapabilityId(String capabilityId);

    public void updateCost(String capabilityId, Integer cost);

    public List<Capability> getAll();
}

package com.bupt.openiot.dao.capability;

import com.bupt.openiot.dao.mapper.CapabilityMapper;
import com.bupt.openiot.dao.model.Capability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dy on 2017/5/24.
 */
@Service
public class CapabilityServiceImpl implements CapabilityService {

    @Autowired
    private CapabilityMapper capabilityMapper;

    @Override
    public List<Capability> getByDeviceId(String deviceId) {
        Capability capability = new Capability();
        capability.setDeviceid(deviceId);
        return capabilityMapper.select(capability);
    }

    @Override
    public Capability getByCapabilityId(String capabilityId) {
        Capability capability = new Capability();
        capability.setCapabilityid(capabilityId);
        return capabilityMapper.selectOne(capability);
    }

    @Override
    public void updateCost(String capabilityId, Integer cost) {
        Capability queryCapability = new Capability();
        queryCapability.setCapabilityid(capabilityId);
        Capability capability = capabilityMapper.selectOne(queryCapability);
        capability.setCost(Long.valueOf(cost));
        capabilityMapper.updateByPrimaryKey(capability);
    }

    @Override
    public List<Capability> getAll() {
        return capabilityMapper.selectAll();
    }
}

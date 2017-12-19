package com.bupt.openiot.dao.devicegroup;

import com.bupt.openiot.dao.mapper.DeviceBindGroupMapper;
import com.bupt.openiot.dao.model.DeviceBindGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dy on 2017/5/14.
 */
@Service
public class DeviceBindGroupServiceimpl implements DeviceBindGroupService {

    @Autowired
    private DeviceBindGroupMapper deviceBindGroupMapper;


    @Override
    public int deviceCountByDeviceGroupId(String deviceGroupId) {
        DeviceBindGroup bind = new DeviceBindGroup();
        bind.setDevicegroupid(deviceGroupId);
        return deviceBindGroupMapper.selectCount(bind);
    }
}

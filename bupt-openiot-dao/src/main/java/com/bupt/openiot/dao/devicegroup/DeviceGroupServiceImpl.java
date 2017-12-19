package com.bupt.openiot.dao.devicegroup;

import com.bupt.openiot.dao.mapper.DeviceGroupMapper;
import com.bupt.openiot.dao.model.DeviceGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dy on 2017/5/14.
 */
@Service
public class DeviceGroupServiceImpl implements DeviceGroupService {

    @Autowired
    private DeviceGroupMapper deviceGroupMapper;

    @Override
    public List<DeviceGroup> getAll() {
        return deviceGroupMapper.selectAll();
    }

    @Override
    public void create(DeviceGroup deviceGroup) {
        deviceGroup.setCreatetime(new Date());
        deviceGroupMapper.insert(deviceGroup);
    }

    @Override
    public void delete(String deviceGroupId) {
        DeviceGroup deviceGroup = new DeviceGroup();
        deviceGroup.setDevicegroupid(deviceGroupId);
        deviceGroupMapper.delete(deviceGroup);
    }
}

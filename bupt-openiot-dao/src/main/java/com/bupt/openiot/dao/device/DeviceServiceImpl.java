package com.bupt.openiot.dao.device;

import com.bupt.openiot.dao.mapper.DeviceBindGroupMapper;
import com.bupt.openiot.dao.mapper.DeviceGroupMapper;
import com.bupt.openiot.dao.mapper.DeviceMapper;
import com.bupt.openiot.dao.model.Device;
import com.bupt.openiot.dao.model.DeviceBindGroup;
import com.bupt.openiot.dao.model.DeviceGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by dy on 2017/5/14.
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceGroupMapper deviceGroupMapper;

    @Autowired
    private DeviceBindGroupMapper deviceBindGroupMapper;

    @Override
    public List<Device> getAll() {
        return deviceMapper.selectAll();
    }

    @Override
    public void create(String name, String description, String devicepath) {
        /*插入设备记录*/
        Device device = new Device();
        String deviceId = UUID.randomUUID().toString();
        device.setName(name);
        device.setDeviceid(deviceId);
        device.setDescription(description);
        device.setLasttime(new Date());
        device.setStatus("可用");
        deviceMapper.insert(device);

        /*插入设备组记录*/
        DeviceGroup selectDeviceGroup = new DeviceGroup();
        String deviceGroupId = UUID.randomUUID().toString();
        selectDeviceGroup.setPath(devicepath);
        DeviceGroup resDeviceGroup = deviceGroupMapper.selectOne(selectDeviceGroup);
        if (resDeviceGroup == null) {
            DeviceGroup deviceGroup = new DeviceGroup();
            deviceGroup.setPath(devicepath);
            deviceGroup.setDevicegroupid(deviceGroupId);
            deviceGroup.setCreatetime(new Date());
            deviceGroup.setDescription("");
            deviceGroupMapper.insert(deviceGroup);
        }
        if (resDeviceGroup != null && resDeviceGroup.getDevicegroupid() != null) {
            deviceGroupId = resDeviceGroup.getDevicegroupid();
        }

        /*插入关联表记录*/
        DeviceBindGroup deviceBindGroup = new DeviceBindGroup();
        deviceBindGroup.setDeviceid(deviceId);
        deviceBindGroup.setDevicegroupid(deviceGroupId);
        deviceBindGroupMapper.insert(deviceBindGroup);
    }

    @Override
    public void delete(String deviceId) {
        Device device = new Device();
        device.setDeviceid(deviceId);
        deviceMapper.delete(device);
        DeviceBindGroup deviceBindGroup = new DeviceBindGroup();
        deviceBindGroup.setDeviceid(deviceId);
        deviceBindGroupMapper.delete(deviceBindGroup);
    }

    @Override
    public Device getOneByDeviceId(String deviceId) {
        Device device = new Device();
        device.setDeviceid(deviceId);
        return deviceMapper.selectOne(device);
    }
}

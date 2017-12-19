package com.bupt.openiot.service.convert;

import com.bupt.openiot.dao.devicegroup.DeviceBindGroupService;
import com.bupt.openiot.dao.model.DeviceGroup;
import com.bupt.openiot.model.DeviceGroupWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dy on 2017/5/14.
 */
@Service
public class ConvertToViewTool {

    @Autowired
    private DeviceBindGroupService deviceBindGroupService;

    public List<DeviceGroupWrapper> convertToView(List<DeviceGroup> deviceGroupList) {
        List<DeviceGroupWrapper> result = new ArrayList<>();
        for (DeviceGroup deviceGroup : deviceGroupList) {
            DeviceGroupWrapper deviceGroupWrapper = new DeviceGroupWrapper();
            deviceGroupWrapper.setId(deviceGroup.getId());
            deviceGroupWrapper.setDevicegroupid(deviceGroup.getDevicegroupid());
            deviceGroupWrapper.setCreatetime(deviceGroup.getCreatetime());
            deviceGroupWrapper.setPath(deviceGroup.getPath());
            deviceGroupWrapper.setDescription(deviceGroup.getDescription());
            //deviceGroupWrapper.setDeviceCount(deviceBindGroupService.deviceCountByDeviceGroupId(deviceGroup.getDevicegroupid()));
            deviceGroupWrapper.setDeviceCount(1);
            result.add(deviceGroupWrapper);
        }
        return result;
    }
}

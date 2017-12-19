package com.bupt.openiot.dao.devicegroup;

import com.bupt.openiot.dao.model.DeviceGroup;

import java.util.List;

/**
 * Created by dy on 2017/5/14.
 */
public interface DeviceGroupService {

    public List<DeviceGroup> getAll();

    public void create(DeviceGroup deviceGroup);

    public void delete(String deviceGroupId);
}

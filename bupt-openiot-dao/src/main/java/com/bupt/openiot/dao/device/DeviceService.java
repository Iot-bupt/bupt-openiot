package com.bupt.openiot.dao.device;

import com.bupt.openiot.dao.model.Device;

import java.util.List;

/**
 * Created by dy on 2017/5/14.
 */
public interface DeviceService {

    public List<Device> getAll();

    public Device getOneByDeviceId(String deviceId);

    public void create(String name, String description, String devicepath);

    public void delete(String deviceId);
}

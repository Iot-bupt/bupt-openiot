package com.bupt.openiot.controller;

import com.bupt.openiot.dao.device.DeviceService;
import com.bupt.openiot.dao.model.Device;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dy on 2017/4/21.
 */
@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/noauth/profile")
    public ModelAndView profileView(@RequestParam String deviceId) {
        ModelAndView result = new ModelAndView("profile");
        //Device device = deviceService.getOneByDeviceId(deviceId);
        Device device=new Device();
        device.setId(1);
        device.setDeviceid("test_1");
        device.setName("pf_device");
        device.setDescription("测试设备");
        device.setLasttime(new Date());
        device.setProtocol("mqtt");
        device.setStatus("在运");
        result.addObject("device", device);
        return result;
    }
}

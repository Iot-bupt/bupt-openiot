package com.bupt.openiot.controller;

import com.bupt.openiot.conf.OpenIoTServerConfig;
import com.bupt.openiot.dao.capability.CapabilityService;
import com.bupt.openiot.dao.device.DeviceService;
import com.bupt.openiot.dao.model.Capability;
import com.bupt.openiot.dao.model.Device;
import com.bupt.openiot.internalsdk.util.HttpClientUtil;
import com.bupt.openiot.model.LightCommand;
import com.bupt.openiot.model.LoginToken;
import com.bupt.openiot.model.PinParams;
import com.bupt.openiot.model.Pins;
import com.bupt.openiot.model.request.DeviceRequest;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dy on 2017/4/21.
 */
@RestController
@RequestMapping("/api")
public class DeviceManageController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private CapabilityService capabilityService;

    @Autowired
    private OpenIoTServerConfig openIoTServerConfig;

    @RequestMapping(value = "/noauth/devicemanage")
    public ModelAndView deviceView() {
        ModelAndView result = new ModelAndView("instance");
        return result;
    }

    /**
     * 打开设备详情
     * @param deviceId
     * @return
     */
    @RequestMapping("/noauth/devicemanage/property")
    public ModelAndView property(@RequestParam String deviceId) {
        ModelAndView result = new ModelAndView("property");
        Device device = deviceService.getOneByDeviceId(deviceId);
        List<Capability> capabilityList = capabilityService.getByDeviceId(deviceId);
        result.addObject("device", device);
        result.addObject("pageInfo", new PageInfo<Capability>(capabilityList));
        return result;
    }

    /**
     * 控制设备
     * @param deviceId
     * @return
     */
    @RequestMapping("/noauth/devicemanage/control")
    public ModelAndView control(@RequestParam String deviceId) {
        ModelAndView result = new ModelAndView("lightcontrol");
        //Device deviceInfo = deviceService.getOneByDeviceId(deviceId);
        //List<Capability> capabilityList = capabilityService.getByDeviceId(deviceId);
        //result.addObject("device", deviceInfo);
        //result.addObject("pageInfo", new PageInfo<Capability>(capabilityList));
        Device device=new Device();
        device.setId(1);
        device.setDeviceid("test_1");
        device.setName("pf_device");
        device.setDescription("测试设备");
        device.setLasttime(new Date());
        device.setProtocol("mqtt");
        device.setStatus("在运");
        Capability capability = new Capability();
        capability.setId((long)1);
        List<Capability> capabilitiesList = new ArrayList();
        capabilitiesList.add(capability);
        result.addObject("device", device);
        result.addObject("pageInfo", new PageInfo<Capability>(capabilitiesList));
        return result;
    }

    @RequestMapping("/noauth/device/test")
    public PageInfo<Device> test() {
        List<Device> deviceList = deviceService.getAll();
        return new PageInfo<Device>(deviceList);
    }

    @RequestMapping("/noauth/device/light")
    public String lightOn(@RequestParam String status, HttpServletRequest request) {
        HttpSession session = request.getSession();
        LightCommand lightCommand = new LightCommand();
        lightCommand.setMethod("setGpioStatus");
        lightCommand.setTimeout(500);
        PinParams pinParams = new PinParams();
        pinParams.setPin(3);
        if ("on".equalsIgnoreCase(status)) {
            pinParams.setEnabled(true);
        } else {
            pinParams.setEnabled(false);
        }
        lightCommand.setParams(pinParams);

        Gson gson = new Gson();
        String command = gson.toJson(lightCommand);
        String token = (String) session.getAttribute("token");
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpPost("http://" + openIoTServerConfig.getServer()
                        + "/api/plugins/rpc/twoway/e63beb40-42e5-11e7-8b7b-cd30e8402e61", command, token);
        Pins pins = gson.fromJson(responseContent, Pins.class);
        if (pins.isValue3()) {
            return "on";
        } else {
            return "off";
        }
    }

    /**
     * 创建设备
     * @param deviceRequest
     * @return
     */
    @RequestMapping(value = "/noauth/device/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestBody DeviceRequest deviceRequest) {
        ModelAndView result = new ModelAndView("homepage");
        deviceService.create(deviceRequest.getName(), deviceRequest.getDescription(), deviceRequest.getDevicegroup());
        List<Device> deviceList = deviceService.getAll();
        result.addObject("pageInfo", new PageInfo<Device>(deviceList));
        result.addObject("queryParam", null);
        return result;
    }

    @RequestMapping(value = "/noauth/device/createMod", method = RequestMethod.POST)
    public ModelAndView createMod(@RequestParam("petemplate") String str) {
        ModelAndView result = new ModelAndView("homepage");
        System.out.println(str);
        //保存影子信息
        List<Device> deviceList = deviceService.getAll();
        result.addObject("pageInfo", new PageInfo<Device>(deviceList));
        result.addObject("queryParam", null);
        return result;
    }

    /**
     * 删除设备
     * @param deviceId
     * @return
     */
    @RequestMapping(value = "/noauth/device/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam String deviceId) {
        ModelAndView result = new ModelAndView("homepage");
        System.out.println(deviceId);
        deviceService.delete(deviceId);
        List<Device> deviceList = deviceService.getAll();
        result.addObject("pageInfo", new PageInfo<Device>(deviceList));
        result.addObject("queryParam", null);
        return result;
    }
}

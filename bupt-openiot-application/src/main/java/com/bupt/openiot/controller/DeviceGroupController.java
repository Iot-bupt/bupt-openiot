package com.bupt.openiot.controller;

import com.bupt.openiot.dao.devicegroup.DeviceGroupService;
import com.bupt.openiot.dao.model.DeviceGroup;
import com.bupt.openiot.model.DeviceGroupWrapper;
import com.bupt.openiot.service.convert.ConvertToViewTool;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dy on 2017/4/21.
 */
@RestController
@RequestMapping("/api/group")
public class DeviceGroupController {

    @Autowired
    private DeviceGroupService deviceGroupService;

    @Autowired
    private ConvertToViewTool convertToViewTool;

    @RequestMapping(value = "/noauth/devicegroup")
    public ModelAndView devicegroupView() {
        ModelAndView result = new ModelAndView("device_group");
        //List<DeviceGroup> deviceGroupList = deviceGroupService.getAll();
        //List<DeviceGroupWrapper> deviceGroupMapperList = convertToViewTool.convertToView(deviceGroupList);
        //result.addObject("pageInfo", new PageInfo<DeviceGroupWrapper>(deviceGroupMapperList));
        //result.addObject("queryParam", null);
        DeviceGroup deviceGroup = new DeviceGroup();
        deviceGroup.setId(1);
        deviceGroup.setPath("test_path");
        deviceGroup.setDevicegroupid("test_device_group_1");
        deviceGroup.setDescription("test");
        deviceGroup.setCreatetime(new Date());
        List<DeviceGroup> deviceGroupList = new ArrayList();
        deviceGroupList.add(deviceGroup);
        List<DeviceGroupWrapper> deviceGroupMapperList = convertToViewTool.convertToView(deviceGroupList);
        result.addObject("pageInfo", new PageInfo<DeviceGroupWrapper>(deviceGroupMapperList));
        result.addObject("queryParam", null);
        return result;
    }

    @RequestMapping(value = "/noauth/devicegroup/data")
    public PageInfo<DeviceGroupWrapper> devicegroupList() {
        List<DeviceGroup> deviceGroupList = deviceGroupService.getAll();
        List<DeviceGroupWrapper> deviceGroupMapperList = convertToViewTool.convertToView(deviceGroupList);
        return new PageInfo<DeviceGroupWrapper>(deviceGroupMapperList);
    }

    @RequestMapping(value = "/noauth/devicegroup/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestBody DeviceGroup deviceGroup) {
        ModelAndView result = new ModelAndView("device_group");
        System.out.println(deviceGroup.toString());
        deviceGroupService.create(deviceGroup);
        List<DeviceGroup> deviceGroupList = deviceGroupService.getAll();
        List<DeviceGroupWrapper> deviceGroupMapperList = convertToViewTool.convertToView(deviceGroupList);
        result.addObject("pageInfo", new PageInfo<DeviceGroupWrapper>(deviceGroupMapperList));
        result.addObject("queryParam", null);
        return result;
    }

    @RequestMapping(value = "/noauth/devicegroup/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam String deviceGroupId) {
        ModelAndView result = new ModelAndView("device_group");
        System.out.println(deviceGroupId);
        deviceGroupService.delete(deviceGroupId);
        List<DeviceGroup> deviceGroupList = deviceGroupService.getAll();
        List<DeviceGroupWrapper> deviceGroupMapperList = convertToViewTool.convertToView(deviceGroupList);
        result.addObject("pageInfo", new PageInfo<DeviceGroupWrapper>(deviceGroupMapperList));
        result.addObject("queryParam", null);
        return result;
    }
    @RequestMapping(value = "/{tenantId}/groups", method = RequestMethod.GET)
    public String findGroups(@PathVariable("tenantId") String tId, @RequestParam int limit,
    		                                           @RequestParam(required = false) String textSearch,
    		                                           @RequestParam(required = false) String idOffset,
    		                                           @RequestParam(required = false) String textOffset){
    	
    	return null;
    }
}

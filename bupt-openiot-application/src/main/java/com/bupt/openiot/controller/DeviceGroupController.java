package com.bupt.openiot.controller;

import com.bupt.openiot.conf.OpenIoTServerConfig;
import com.bupt.openiot.dao.devicegroup.DeviceGroupService;
import com.bupt.openiot.dao.model.DeviceGroup;
import com.bupt.openiot.internalsdk.util.HttpClientUtil;
import com.bupt.openiot.model.DeviceGroupWrapper;
import com.bupt.openiot.service.convert.ConvertToViewTool;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    private OpenIoTServerConfig openIoTServerConfig;

    @Autowired
    private HttpServletRequest request;

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

//    @RequestMapping(value = "/noauth/devicegroup/data")
//    public PageInfo<DeviceGroupWrapper> devicegroupList() {
//        List<DeviceGroup> deviceGroupList = deviceGroupService.getAll();
//        List<DeviceGroupWrapper> deviceGroupMapperList = convertToViewTool.convertToView(deviceGroupList);
//        return new PageInfo<DeviceGroupWrapper>(deviceGroupMapperList);
//    }

//    @RequestMapping(value = "/noauth/devicegroup/create", method = RequestMethod.POST)
//    public ModelAndView create(@RequestBody DeviceGroup deviceGroup) {
//        ModelAndView result = new ModelAndView("device_group");
//        System.out.println(deviceGroup.toString());
//        deviceGroupService.create(deviceGroup);
//        List<DeviceGroup> deviceGroupList = deviceGroupService.getAll();
//        List<DeviceGroupWrapper> deviceGroupMapperList = convertToViewTool.convertToView(deviceGroupList);
//        result.addObject("pageInfo", new PageInfo<DeviceGroupWrapper>(deviceGroupMapperList));
//        result.addObject("queryParam", null);
//        return result;
//    }

//    @RequestMapping(value = "/noauth/devicegroup/delete", method = RequestMethod.GET)
//    public ModelAndView delete(@RequestParam String deviceGroupId) {
//        ModelAndView result = new ModelAndView("device_group");
//        System.out.println(deviceGroupId);
//        deviceGroupService.delete(deviceGroupId);
//        List<DeviceGroup> deviceGroupList = deviceGroupService.getAll();
//        List<DeviceGroupWrapper> deviceGroupMapperList = convertToViewTool.convertToView(deviceGroupList);
//        result.addObject("pageInfo", new PageInfo<DeviceGroupWrapper>(deviceGroupMapperList));
//        result.addObject("queryParam", null);
//        return result;
//    }
//    @RequestMapping(value = "/{tenantId}/groups", method = RequestMethod.GET)
//    public String findGroups(@PathVariable("tenantId") String tId, @RequestParam int limit,
//    		                                           @RequestParam(required = false) String textSearch,
//    		                                           @RequestParam(required = false) String idOffset,
//    		                                           @RequestParam(required = false) String textOffset){
//
//    	return null;
//    }

    @RequestMapping(value = "/noauth/devicegroup/data", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String devicegroupList() {
        String requestAddr = "/api/group/groups" ;

        String token = (String)request.getSession().getAttribute("token");

        StringBuffer param = new StringBuffer();
        param.append("limit").append("=").append("100");

        String responseContent = HttpClientUtil.getInstance()
                .sendHttpGet("http://" + openIoTServerConfig.getServer()
                        + requestAddr, param.toString(), token);

        JsonElement parse = new JsonParser().parse(responseContent);
        JsonObject parsed = (JsonObject) parse ;

        return parsed.toString() ;
    }

    @RequestMapping(value = "/noauth/devicegroup/create", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String create(@RequestBody String deviceGroupInfo) {
        String requestAddr = "/api/group/save" ;

        String token = (String)request.getSession().getAttribute("token");

        String responseContent = HttpClientUtil.getInstance()
                .sendHttpPost("http://" + openIoTServerConfig.getServer()
                        + requestAddr, deviceGroupInfo, token) ;

        JsonElement parse = new JsonParser().parse(responseContent);
        JsonObject parsed = (JsonObject) parse ;

        return parsed.toString() ;
    }

    @RequestMapping(value = "/noauth/devicegroup/delete", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestParam String deviceGroupId) {
        String requestAddr = String.format("/api/group/delete/%s", deviceGroupId);

        String token = (String)request.getSession().getAttribute("token");

        String responseContent = HttpClientUtil.getInstance()
                .sendHttpGet("http://" + openIoTServerConfig.getServer()
                        + requestAddr, "", token) ;

        JsonElement parse = new JsonParser().parse(responseContent);
        JsonObject parsed = (JsonObject) parse ;

        return parsed.toString() ;
    }
}

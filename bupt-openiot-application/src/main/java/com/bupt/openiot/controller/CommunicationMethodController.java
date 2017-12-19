package com.bupt.openiot.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bupt.openiot.conf.OpenIoTServerConfig;
import com.bupt.openiot.dao.communication.CommunicationMethodService;
/*import com.bupt.openiot.dao.communication.CommunicationMethodService;*/
import com.bupt.openiot.dao.model.ComMethod;
import com.bupt.openiot.dto.DeviceDto;
import com.bupt.openiot.internalsdk.util.HttpClientUtil;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/api")
public class CommunicationMethodController {

	@Autowired
	private CommunicationMethodService communicationMethodService;
	
	
	
	@RequestMapping(value = "/noauth/communicationmethod", method = RequestMethod.GET)
	@ResponseBody
	public String getAll(){
		List<ComMethod> list=new ArrayList();
		ComMethod comMethod=new ComMethod();
		comMethod.setId((long) 1);
		comMethod.setComMethodId("method_1");
		comMethod.setComMethod("test_method_1");
		list.add(comMethod);
		
		return new Gson().toJson(list);
	}
	
    
}

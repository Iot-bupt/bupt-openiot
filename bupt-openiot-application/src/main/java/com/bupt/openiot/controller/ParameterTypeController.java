package com.bupt.openiot.controller;

import com.bupt.openiot.dao.communication.ParameterTypeService;
import com.bupt.openiot.dao.model.ParameterType;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for ParameterType
 */
@Controller
@RequestMapping("/api")
public class ParameterTypeController {

	@Autowired
	private ParameterTypeService parameterTypeService;
	
	@RequestMapping(value = "/noauth/parametertype", method = RequestMethod.GET)
	@ResponseBody
	public String getAll() {
		List<ParameterType> list = new ArrayList();
		ParameterType parameterType = new ParameterType();
		parameterType.setId((long)1);
		parameterType.setParameterTypeId("parametertype_1");
		parameterType.setParameterType("test_parametertype_1");
		list.add(parameterType);
		return new Gson().toJson(list);
	}
}

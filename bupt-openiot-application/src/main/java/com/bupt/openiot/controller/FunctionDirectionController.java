package com.bupt.openiot.controller;

import com.bupt.openiot.dao.communication.FunctionDirectionService;
import com.bupt.openiot.dao.model.FunDirection;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class FunctionDirectionController {

	@Autowired
	private FunctionDirectionService functionDirectionService;
	
	@RequestMapping(value = "/noauth/functiondirection", method = RequestMethod.GET)
	@ResponseBody
	public String getAll(){
		List<FunDirection> list = new ArrayList();
		FunDirection direction = new FunDirection();
		direction.setId((long)1);
		direction.setFunDirectionId("fundirection_1");
		direction.setFunDirection("test_fundirection_1");
		list.add(direction);
		return new Gson().toJson(list);
	}
}

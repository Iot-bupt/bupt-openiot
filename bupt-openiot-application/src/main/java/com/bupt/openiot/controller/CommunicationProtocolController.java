package com.bupt.openiot.controller;

import com.bupt.openiot.dao.communication.CommunicationProtocolService;
import com.bupt.openiot.dao.model.ComProtocol;
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
public class CommunicationProtocolController {

	@Autowired
	private CommunicationProtocolService communicationProtocolService;
	
	@RequestMapping(value = "/noauth/communicationprotocol", method = RequestMethod.GET)
	@ResponseBody
	public String getAll(){
		List<ComProtocol> list=new ArrayList();
		ComProtocol comProtocol = new ComProtocol();
		comProtocol.setId((long) 1);
		comProtocol.setComProtocolId("comProtocal_1");
		comProtocol.setComProtocol("test_comprotocal_1");
		list.add(comProtocol);
		return new Gson().toJson(list);
	}
}

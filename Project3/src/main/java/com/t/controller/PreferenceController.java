package com.t.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.t.service.PreferenceService;

@Controller
public class PreferenceController {

	PreferenceService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(PreferenceService service) {
		this.service = service;
	}
	
	
}

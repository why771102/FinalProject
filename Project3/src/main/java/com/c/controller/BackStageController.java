package com.c.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackStageController {

	@GetMapping("/backstageindex")
	public String backstageIndex() {
		return "bgExample/index";
	}
}

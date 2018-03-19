package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuideController {
	
	@RequestMapping("/guide")
	public String guide() {
		return "converter";
	}
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/guide";
	}
}

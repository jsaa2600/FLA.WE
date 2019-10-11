package com.kh.myprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;

@Controller
@RequestMapping("/jquery")
public class TestJquery {

	
	@GetMapping("/test")
	public String jqueryTest() {
		
		return "/test/jquery";
	}
	
}

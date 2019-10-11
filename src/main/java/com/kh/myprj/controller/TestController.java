package com.kh.myprj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private static final Logger logger
	= LoggerFactory.getLogger(TestController.class);
	
	@GetMapping("/member")
//	@RequestMapping("/member") 
	public String member(
			@RequestParam("name") String name,
			@RequestParam("age") String age) {
		
		logger.info("member()호출");
		logger.info("name="+name);
		logger.info("age="+age);
		return "/test/member";
	}
	
	@PostMapping("/member")
//	@RequestMapping(value="/member", method=RequestMethod.POST) 
	public String memberPost(
			@RequestParam("name") String name,
			@RequestParam("age") String age) {
		
		logger.info("memberPost()호출");
		logger.info("name="+name);
		logger.info("age="+age);
		return "/test/member";
	}	
	
	
	

}








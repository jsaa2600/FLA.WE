package com.kh.myprj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.myprj.test.Code;
import com.kh.myprj.test.MemberDTO;

@Controller
@RequestMapping("/test")
public class TestController10 {
	
	private Logger logger = LoggerFactory.getLogger(TestController10.class);
	 
	// @formatter:on

	@ModelAttribute
	public void initRgion(Model model) {
		
		List<Code> list = new ArrayList<>();
		
		list.add(new Code("01","서울"));
		list.add(new Code("02","대전"));
		list.add(new Code("03","대구"));
		list.add(new Code("04","부산"));
		list.add(new Code("05","찍고"));

		model.addAttribute("region", list);
	}
		
	
	@GetMapping("/join")
	public String join(Model model) {
		model.addAttribute("memberDTO", new MemberDTO());
		return "/test/memberJoinForm";
	}
	
//	@PostMapping("/memberJoin")
//	public String membjerJoin(
//			@RequestParam("id") String id,
//			@RequestParam("nickname") String nickname,
//			@RequestParam("age") String age) {
//		
//		logger.info("id:"+id);
//		logger.info("nickname:"+nickname);
//		logger.info("age:"+age);
//
//		return "redirect:/";
//	}
	
	@PostMapping("/memberJoin")
	public String membjerJoin(
			@Valid @ModelAttribute MemberDTO memberDTO, BindingResult result) {
		
		logger.info("id:"+memberDTO.getId());
		logger.info("nickname:"+memberDTO.getNickname());
		logger.info("age:"+memberDTO.getAge());
		
		if(result.hasErrors()) {
			logger.info(result.toString());
			return "/test/memberJoinForm";
			//return "redirect:/test/join";
		}

		return "redirect:/";
	}
	
}











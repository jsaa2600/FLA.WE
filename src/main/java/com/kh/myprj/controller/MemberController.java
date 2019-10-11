package com.kh.myprj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.myprj.common.Code;
import com.kh.myprj.login.service.LoginSvc;
import com.kh.myprj.member.dto.MemberDTO;
import com.kh.myprj.member.dto.PasswdDTO;
import com.kh.myprj.member.service.MemberSvc;

@Controller
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger
		= LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberSvc memberSvc;
	@Inject
	private LoginSvc loginSvc;
	
	@ModelAttribute
	public void initData(Model model) {
		//지역
		List<Code> region = new ArrayList<>();
		region.add(new Code("서울","서울"));
		region.add(new Code("경기","경기"));
		region.add(new Code("인천","인천"));
		region.add(new Code("대전","대전"));
		region.add(new Code("충북","충북"));
		region.add(new Code("충남","충남"));
		region.add(new Code("강원","강원"));
		region.add(new Code("전북","전북"));
		region.add(new Code("전남","전남"));
		region.add(new Code("경북","경북"));
		region.add(new Code("경남","경남"));
		region.add(new Code("부산","부산"));
		region.add(new Code("울산","울산"));
		region.add(new Code("제주","제주"));
		
		model.addAttribute("region", region);
		
		//성별
		List<Code> gender = new ArrayList<>();
		gender.add(new Code("남","남자"));
		gender.add(new Code("여","여자"));
		
		model.addAttribute("gender", gender);
	}
	
	
	//회원가입 양식
	@GetMapping("/memberJoinForm")
	public String memberJoinForm(Model model) {
		logger.info("memberJoinForm() 호출");
		model.addAttribute("mdto", new MemberDTO());	
		return "/member/memberJoinForm";
	}
	
	//회원등록 처리
	@PostMapping("/memberJoin")
	public String memberJoin(
			@Valid @ModelAttribute("mdto") MemberDTO memberDTO,
			BindingResult result,
			Model model) {

		String viewName = null;
		
		logger.info("memberJoin()호출");
		logger.info(memberDTO.toString());
		
		logger.info(result.toString());
		if(result.hasErrors()) {
			logger.info("회원가입시 오류발생");
			return "/member/memberJoinForm";
		}
		
		//회원중복체크
		if(memberSvc.getMember(memberDTO.getId()) != null) {
			viewName = "/member/memberJoinForm";
			model.addAttribute("svr_msg", "중복된아이디입니다");
			return viewName;
		};
		
		//회원등록
		int cnt = memberSvc.insert(memberDTO);
		if(cnt == 1) {
			viewName = "redirect:/";
		}else {
			viewName = "/member/memberJoinForm";
		}
		return viewName;
	}
	
	//회원목록조회
	@GetMapping("/memberList")
	public String member(Model model) {
		
			List<MemberDTO> list = memberSvc.getMemberList();
			model.addAttribute("memberList", list);
		
			logger.info(list.toString());
			
		return "/member/memberList";
	}
	
	//회원수정
	@GetMapping("/memberModifyForm/{id:.+}")
	public String memberModifyForm(@PathVariable String id, Model model) {
		logger.info("id:"+id);
		
		MemberDTO memberDTO = memberSvc.getMember(id);
		model.addAttribute("memberDTO", memberDTO);
		logger.info("memberDTO:"+ memberDTO);
		
		return "/member/memberModifyForm";
	}
	
	//회원수정처리
	@GetMapping("/memberModify")
	public String memberModify(MemberDTO memberDTO, HttpSession session) {
		
		int result = memberSvc.modify(memberDTO);
		logger.info("수정처리결과:"+ result);
		
		if(result == 1) {
			MemberDTO mdto = loginSvc.getMember(
					memberDTO.getId(), ((MemberDTO)session.getAttribute("user")).getPw());
			
			//기존 회원정보  제거 후 변경된 정보로 반영
			session.removeAttribute("user");
			session.setAttribute("user", mdto);
			
			return "redirect:/";
		}else {
			return "/member/memberModifyForm/"+memberDTO.getId();
		}
	}
	//회원탈퇴화면
	@GetMapping("/memberOutForm")
	public String memberOut() {
		
		return "/member/memberOutForm";
	}
	//회원삭제처리(회원용)
	@PostMapping("/memberOut")
	public String memberDelete(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			HttpSession session) {
		
		int result = memberSvc.delete(id,pw);
		logger.info("회원탈퇴처리결과:" + result);
		
		if(result == 1) {
			session.invalidate();
			return "redirect:/";
						
		}
		return "/member/memberOutForm";
	}
	
	//회원삭제처리(관리자용)
	@GetMapping("/memberDelete/{id:.+}")
	public String memberDelete(@PathVariable String id) {
		
		int result = memberSvc.delete(id);
		logger.info("삭제처리결과:" + result);
		
		return "redirect:/member/memberList";
	}	
	
	
	//회원비밀번호 변경 양식
	@GetMapping("/changePwForm")
	public void changePwForm(Model model) {
		
		model.addAttribute("passwdDTO",new PasswdDTO());

	}
	
	//회원비밀번호변경 처리
	@PostMapping("/changePw")
	public String changePw(@Valid @ModelAttribute PasswdDTO passwdDTO,
			BindingResult result) {
		
		//바인딩 오류시
		if(result.hasErrors()) {
			logger.info(result.toString());
			return "/member/changePwForm";
		}
		
		//비밀번호변경
		int cnt = memberSvc.changePw(passwdDTO);
		
		if(cnt == 1) {		
			return "redirect:/";
		}
		return "/member/changePwForm";
	}
	
	
}










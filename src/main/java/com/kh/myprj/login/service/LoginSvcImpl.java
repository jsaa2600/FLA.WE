package com.kh.myprj.login.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.myprj.member.dto.MemberDTO;
import com.kh.myprj.login.dao.LoginDAO;

@Service
public class LoginSvcImpl implements LoginSvc{

	@Inject
	private LoginDAO loginDAO;
	
	@Override
	public int isMember(String id, String pw) {
		
		return loginDAO.isMember(id, pw);
		
	}

	@Override
	public MemberDTO getMember(String id, String pw) {
		
		return loginDAO.getMember(id, pw);
	}

}

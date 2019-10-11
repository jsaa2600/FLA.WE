package com.kh.myprj.login.dao;

import com.kh.myprj.member.dto.MemberDTO;

public interface LoginDAO {

	//회원 유무 체크
	int isMember(String id, String pw);
	
	//회원정보 가져오기
	MemberDTO getMember(String id, String pw);
	
}

package com.kh.myprj.member.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myprj.member.dao.MemberDAO;
import com.kh.myprj.member.dto.MemberDTO;
import com.kh.myprj.member.dto.PasswdDTO;

@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMemberDAOImplJDBC {
	
	private final static Logger logger 
	 	= LoggerFactory.getLogger(TestMemberDAOImplJDBC.class);
	
	@Inject
	@Qualifier("memberDAOImplXML")
	MemberDAO mdaoImpl;
	
	@Test
	@Disabled
	void testInsert() {
		MemberDTO mdto = new MemberDTO();
		mdto.setId("test@test.com");
		mdto.setPw("1234");
		mdto.setTel("010-1234-5678");
		mdto.setNickname("한아름");
		mdto.setGender("여");
		mdto.setRegion("울산");
		mdto.setBirth("2000-01-01");
		
		int cnt = mdaoImpl.insert(mdto);
		assertEquals(1, cnt);
	}
	

	@Test
	@Disabled
	void testModify() {
		MemberDTO mdto = new MemberDTO();
		mdto.setId("test@test.com");
		mdto.setPw("1234");
		mdto.setTel("010-1234-5678");
		mdto.setNickname("한아름2");
		mdto.setGender("여");
		mdto.setRegion("울산");
		mdto.setBirth("2000-01-01");
		
		int cnt = mdaoImpl.modify(mdto);
		assertEquals(1, cnt);		
	}
	
	@Test
	@Disabled
	void testDelete() {
		
		int cnt = mdaoImpl.delete("test@test.com");
		assertEquals(1, cnt);	
	}
	
	@Test
	@Disabled
	void testGetMember() {
		MemberDTO mdto = mdaoImpl.getMember("test@test.com");
		logger.info(mdto.toString());
		
	}
	
	@Test
	@Disabled
	void testGetMemberList() {
		List<MemberDTO> list = mdaoImpl.getMemberList();
		logger.info(list.toString());
	}
	
	@Test
	void testChangePw() {
		PasswdDTO passwdDTO = new PasswdDTO();
		
		String id = "member5@gmail.com";
		String fromPW = "Member5!24";
		String toPW = "1234";
		
		passwdDTO.setId(id);
		passwdDTO.setFromPW(fromPW);
		passwdDTO.setToPW(toPW);
		
		assertEquals(1, mdaoImpl.changePw(passwdDTO));
		
	}
}














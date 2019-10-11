package com.kh.myprj.login;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myprj.member.dao.TestMemberDAOImplJDBC;
import com.kh.myprj.login.dao.LoginDAO;
import com.kh.myprj.member.dto.MemberDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestLoginDAOImplJDBC {

	private final static Logger logger 
 	= LoggerFactory.getLogger(TestMemberDAOImplJDBC.class);
	
	@Inject
	private LoginDAO loginDAO;
	
	String id, pw;
			
	@BeforeEach
	void init() {
		id = "sang105kr@gmail.com";
		pw = "1Az01624!";		
	}
	
	@Test
	void testIsMember() {		
		int result = loginDAO.isMember(id, pw);	
		assertEquals(1, result);		
	}
	
	@Test
	void testGetMember() {
	
		MemberDTO mdto = loginDAO.getMember(id, pw);		
		logger.info(mdto.toString());
		assertEquals("01022223333", mdto.getTel());		
	}	
}














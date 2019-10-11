package com.kh.myprj.student;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.Data;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestDeleteJdbcTemplate {

	@Inject
	JdbcTemplate jt;
	
	StringBuffer sql;
	
	@BeforeEach // @Test 메소드 실행전에 실행할 명령어 정의
	void before() {
		sql = new StringBuffer();
	}	
	
	@Test
	void delete() {
		
//		jt.update
	}
}















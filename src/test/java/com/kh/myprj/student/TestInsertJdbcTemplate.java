package com.kh.myprj.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestInsertJdbcTemplate {
	
	private static Logger logger = LoggerFactory.getLogger(TestInsertJdbcTemplate.class);
	
	@Inject
	JdbcTemplate jt;
	
	StringBuffer sql = null;
	
	@BeforeEach
	void before() {
		sql = new StringBuffer();		
	}
	
	@Test
	@Disabled
	void insert() {		
		sql.append("insert into student(id,name,kor,eng,math) ");
		sql.append(" values(?,?,?,?,?)");		
		int cnt = jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1, "id1");
					pstmt.setString(2, "name1");
					pstmt.setInt(3, 70);
					pstmt.setInt(4, 80);
					pstmt.setInt(5, 90);

				return pstmt;
			}
		});		
		logger.info("생성건수 : " + cnt);
	}
	
	@Test
	@Disabled
	void insert6() {		
		sql.append("insert into student(id,name,kor,eng,math) ");
		sql.append(" values(?,?,?,?,?)");		
		int cnt = jt.update( con -> {
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "id6");
				pstmt.setString(2, "name6");
				pstmt.setInt(3, 70);
				pstmt.setInt(4, 80);
				pstmt.setInt(5, 90);
				return pstmt;
		});
		
		logger.info("생성건수 : " + cnt);
	}	
	
	@Test
	@Disabled
	void insert3() {
		
		sql.append("insert into student(id,name,kor,eng,math) ");
		sql.append(" values(?,?,?,?,?)");
		
		int cnt = jt.update(sql.toString(), "id3","name3", 60,90,80);
		logger.info("생성건수 : " + cnt);	
	}
	
	
	//2) insert : 치환할값이 없는경우
	@Test
	@Disabled
	void insert2() {
		
		sql.append("insert into student(id,name,kor,eng,math) ");
		sql.append(" values('id2','name2',50,60,70)");
		
		int cnt = jt.update(sql.toString());
		logger.info("생성건수 : " + cnt);		
	}
	
	@Test
	@Disabled
	void insert4() {
		
		sql.append("insert into student(id,name,kor,eng,math) ");
		sql.append(" values(?,?,?,?,?)");		
		
		int cnt = jt.update(sql.toString(), new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, "id4");
				ps.setString(2, "name4");
				ps.setInt(3, 80);
				ps.setInt(4, 85);
				ps.setInt(5, 90);
			}
		});
		
		logger.info("생성건수 : " + cnt);	
	}
	
	@Test
	@Disabled	
	void insert7() {
		
		sql.append("insert into student(id,name,kor,eng,math) ");
		sql.append(" values(?,?,?,?,?)");		
		
		int cnt = jt.update(sql.toString(),  ps -> {
				ps.setString(1, "id7");
				ps.setString(2, "name7");
				ps.setInt(3, 80);
				ps.setInt(4, 85);
				ps.setInt(5, 90);
		});
		
		logger.info("생성건수 : " + cnt);	
	}	
	
	@Test
	@Disabled
	void insert5() {
		
		sql.append("insert into student(id,name,kor,eng,math) ");
		sql.append(" values(?,?,?,?,?)");		
		
		int[] ty= {Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.INTEGER,Types.INTEGER};
		int cnt = jt.update(sql.toString(), 
												new Object[] {"id5","name5",30,40,50}, 
												ty);
		logger.info("생성건수 : " + cnt);			
	}
	
}












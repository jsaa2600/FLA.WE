package com.kh.myprj.bbs.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myprj.bbs.dto.RbbsDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestRbbsDAOImplJDBC {

	private static Logger logger = LoggerFactory.getLogger(TestRbbsDAOImplJDBC.class);
	
	@Inject
	RbbsDAO rbbsDAO;
	
	//댓글 등록
	@Test
	@Disabled
	void test_write() {
		RbbsDTO rbbsDTO = new RbbsDTO();
		rbbsDTO.setBnum(10);
		rbbsDTO.setRid("rereply@test.com");
		rbbsDTO.setRnickname("댓글작성자");
		rbbsDTO.setRcontent("댓글작성내용");
		
		int cnt = rbbsDAO.write(rbbsDTO);
		assertEquals(1, cnt);
		
	};
	
	//댓글 등록
	@Test
	@Disabled
	void test_write2() {
		for(int i=2 ; i<25; i++) {
			RbbsDTO rbbsDTO = new RbbsDTO();
			rbbsDTO.setBnum(10);		
			rbbsDTO.setRid("rereply_"+i+"@test.com");
			rbbsDTO.setRnickname("댓글작성자_"+i);
			rbbsDTO.setRcontent("댓글작성내용_"+i);
			int cnt = rbbsDAO.write(rbbsDTO);
		}
	};
	
	//댓글 목록
	@Test
	@Disabled
	void test_list() {
		
		List<RbbsDTO> list = rbbsDAO.list("10");
		logger.info(list.toString());
		
	};
	@Test
	@Disabled
	void test_list2() {
		List<RbbsDTO> list = rbbsDAO.list("10",11,20);
		logger.info(list.toString());		
		assertEquals(10, list.size());
	};
		
	//댓글 수정
	@Test
	@Disabled
	void test_modify() {
		RbbsDTO rbbsDTO = new RbbsDTO();
		rbbsDTO.setRnum(10);
		rbbsDTO.setRcontent("[수정] 10번댓글에 대한 수정글");
		int cnt = rbbsDAO.modify(rbbsDTO);
		assertEquals(1, cnt);
	};
	
	
	//댓글 삭제
	@Test
	@Disabled
	void test_delete() {
		int cnt = rbbsDAO.delete("24");
		assertEquals(1, cnt);		
	};
	
	
	//댓글 호감 비호감
	@Test
	@Disabled
	void test_goodOrBad() {
		
		int cnt = rbbsDAO.goodOrBad("10", "bad");
		assertEquals(1, cnt);			
	};
	
	//대댓글 등록
	@Test
	@Disabled
	void test_reply() {
//		RbbsDTO rbbsDTO = new RbbsDTO();
//		rbbsDTO.setRnum(1);
//		rbbsDTO.setRid("rereply2@test.com");
//		rbbsDTO.setRnickname("대댓글등록자2");
//		rbbsDTO.setRcontent("대댓글 본문내용!!");
//		
//		int cnt = rbbsDAO.reply(rbbsDTO);
//		assertEquals(1, cnt);		
		
		RbbsDTO rbbsDTO = new RbbsDTO();
		rbbsDTO.setRnum(25);
		rbbsDTO.setRid("rereply3@test.com");
		rbbsDTO.setRnickname("대댓글등록자4");
		rbbsDTO.setRcontent("대댓글 본문내용!!");
		rbbsDTO.setRrnum(1);
		int cnt = rbbsDAO.reply(rbbsDTO);
		assertEquals(1, cnt);			
	};
	
	//대댓글 총계
	@Test
	@Disabled
	void test_replyTotalRec() {
		int cnt = rbbsDAO.replyTotalRec("10");
		assertEquals(25, cnt);
	};
	
}
















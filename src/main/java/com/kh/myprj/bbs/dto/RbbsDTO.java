package com.kh.myprj.bbs.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class RbbsDTO {
	private int rnum;					//댓글번호
	private int bnum;					//최초 원글
	
	private String rid;				//댓글작성자 아이디
	private String rnickname;	//댓글작성자 별칭
	@JsonFormat(pattern = "yyyy-mm-dd h:mm a", timezone = "Asia/Seoul")	
	private Timestamp rcdate;	//댓글작성일시
	@JsonFormat(pattern = "yyyy-mm-dd h:mm a", timezone = "Asia/Seoul")	
	private Timestamp rudate; //댓글수정일시
	
	private String rcontent;	//댓글내용
	private int rgood;				//선호
	private int rbad;					//비선호
	private int rgroup;				//댓글그룹
	private int rstep;				//댓글단계
	private int rindent;			//댓글들여쓰기
	
	private Integer rrnum;		//부모댓글번호
	private String rrnickname;//부모댓글 별칭
	private String rrid;			//부모댓글 아이디
	
}








package com.kh.myprj.test;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class MemberDTO {

	@NotNull
	@Size(min = 4, max = 10, message = "아이디는 4~10자리로 입렵바랍니다.")
	private String id;
	
	@NotNull
	@Size(min = 4, max = 10, message = "별칭 4~10자리로 입렵바랍니다.")	
	private String nickname;
	
	@NotNull(message = "나이는 필수값입니다.")
	private String age;
	
	private String region;
}

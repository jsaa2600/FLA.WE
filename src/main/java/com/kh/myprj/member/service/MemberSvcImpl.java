package com.kh.myprj.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myprj.member.dao.MemberDAO;
import com.kh.myprj.member.dto.MemberDTO;
import com.kh.myprj.member.dto.PasswdDTO;

@Service
public class MemberSvcImpl implements MemberSvc {

	@Inject
	@Qualifier("memberDAOImplXML") //동일타입이 있는경우 id값으로 빈객체를 주입받을 때 사용
	MemberDAO memberDao;
	
	@Override
	public int insert(MemberDTO memberDTO) {
		
		return memberDao.insert(memberDTO);
	}

	@Override
	public int modify(MemberDTO memberDTO) {

		return memberDao.modify(memberDTO);
	}

	@Override
	public int delete(String id, String pw) {

		return memberDao.delete(id,pw);
	}

	@Override
	public int delete(String id) {

		return memberDao.delete(id);
	}

	@Override
	public MemberDTO getMember(String id) {

		return memberDao.getMember(id);
	}

	@Override
	public List<MemberDTO> getMemberList() {

		return memberDao.getMemberList();
	}

	@Override
	public int changePw(PasswdDTO passwdDTO) {
		
		return memberDao.changePw(passwdDTO);
	}

}

package com.kh.myprj.bbs.dao;

import java.util.List;

import com.kh.myprj.bbs.dto.BbsDTO;

public class RbbsDAOImplXML implements BbsDAO {

	@Override
	public int write(BbsDTO bbsDTO) {

		return 0;
	}

	@Override
	public int modify(BbsDTO bbsDTO) {

		return 0;
	}

	@Override
	public int delete(String bnum) {

		return 0;
	}

	@Override
	public BbsDTO view(String bnum) {

		return null;
	}

	@Override
	public List<BbsDTO> list() {

		return null;
	}

	@Override
	public List<BbsDTO> list(int starRec, int endRec) {

		return null;
	}

	@Override
	public List<BbsDTO> list(int starRec, int endRec, String searchType, String keyword) {

		return null;
	}

	@Override
	public int reply(BbsDTO bbsDTO) {

		return 0;
	}

	@Override
	public int totalRec() {

		return 0;
	}

	@Override
	public int searchTotalRec(String searchType, String keyword) {

		return 0;
	}

}

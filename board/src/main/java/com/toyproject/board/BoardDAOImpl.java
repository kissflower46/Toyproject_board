package com.toyproject.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sqlsession;

	@Override
	public int BoardInsertReg(BoardDTO baordDTO) {
		System.out.println("BoardDAOImpl 인코딩 Test");
		return 0;
	}
	
}

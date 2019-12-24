package com.toyproject.board;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSessionTemplate sqlsession;
	
	private final static String BoardMapper = "com.toyproject.board.boardMapper";

	@Override
	public int BoardInsertReg(BoardDTO boardDTO) {
		return sqlsession.insert(BoardMapper+".insertboard", boardDTO);
	}
	
}

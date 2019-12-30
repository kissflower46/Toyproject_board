package com.toyproject.board;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSessionTemplate sqlsession;
	
	private final static String BoardMapper = "com.board.mappers.boardMapper";

	@Override
	public int BoardInsertReg(BoardDTO boardDTO) {
		return sqlsession.insert(BoardMapper+".insertboard", boardDTO);
	}

	@Override
	public List<BoardDTO> BoardList() {
		return sqlsession.selectList(BoardMapper+".boardlist");
	}

	@Override
	public BoardDTO Board_detail(int board_no) {
		return sqlsession.selectOne(BoardMapper+".boarddetail", board_no);
	}

	@Override
	public int BoardUpdateReg(BoardDTO boardDTO) {
		System.out.println(boardDTO.getBoard_no());
		return sqlsession.update(BoardMapper+".boardupdate", boardDTO);
	}

	@Override
	public int BoardDelete(int board_no) {
		return sqlsession.delete(BoardMapper+".boardDelete", board_no);
	}
	
}

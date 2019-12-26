package com.toyproject.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	@Transactional
	public int BoardInsertReg(BoardDTO boardDTO) {
		int insert_cnt = 0;
		try {
			insert_cnt = boardDAO.BoardInsertReg(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insert_cnt;
	}

	@Override
	public List<Map<String, String>> BoardList() {
		return boardDAO.BoardList();
	}

	@Override
	public BoardDTO Board_detail(int board_no) {
		return boardDAO.Board_detail(board_no);
	}

	@Override
	public int BoardUpdateReg(BoardDTO boardDTO) {
		return boardDAO.BoardUpdateReg(boardDTO);
	}

	
}

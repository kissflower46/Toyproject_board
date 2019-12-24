package com.toyproject.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public int BoardInsertReg(BoardDTO boardDTO) {
		System.out.println("인코딩 Test");
		int insert_cnt = 0;
		try {
			insert_cnt = boardDAO.BoardInsertReg(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insert_cnt;
	}
	
}

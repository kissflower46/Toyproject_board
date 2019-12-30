package com.toyproject.board;

import java.util.List;
import java.util.Map;

//인코딩테스트
public interface BoardDAO {
	public int BoardInsertReg(BoardDTO baordDTO);
	public List<BoardDTO> BoardList();
	public BoardDTO Board_detail(int board_no);
	public int BoardUpdateReg(BoardDTO boardDTO);
	public int BoardDelete(int board_no);
}

package com.toyproject.board;

import java.util.List;
import java.util.Map;

public interface BoardService {
	public void BoardInsertReg(BoardDTO boardDTO);
	public List<BoardDTO> BoardList();
	public BoardDTO Board_detail(int board_no);
	public int BoardUpdateReg(BoardDTO boardDTO);
	public int BoardDelete(int board_no);
}

package com.toyproject.board;

import java.util.List;
import java.util.Map;

public interface BoardService {
	public int BoardInsertReg(BoardDTO boardDTO);
	public List<Map<String, String>> BoardList();
}

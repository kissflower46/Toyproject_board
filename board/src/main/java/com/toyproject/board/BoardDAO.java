package com.toyproject.board;

import java.util.List;
import java.util.Map;

//인코딩테스트
public interface BoardDAO {
	public int BoardInsertReg(BoardDTO baordDTO);
	public List<Map<String, String>> BoardList();
}

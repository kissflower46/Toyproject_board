package com.toyproject.board;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/")
	public ModelAndView BoardList() {
		System.out.println("인코딩 Test");
		logger.info("BoardList");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_list");
		return mav;
	}
	
	@RequestMapping(value="/board_insert")
	public ModelAndView BoardInsert() {
		System.out.println("board insert");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_insert");
		return mav;
	}
	
	@RequestMapping(value="/board_insertReg")
	public int BoardInsertReg(BoardDTO boardDTO) {
		logger.info("boardinsertReg");
		int insert_cnt = 0;
		System.out.println(boardDTO.getTitle());
		System.out.println(boardDTO.getContents());
		insert_cnt = boardService.BoardInsertReg(boardDTO);
		System.out.println("왜에러가 나는가?");
		try {
		} catch (Exception e) {
			System.out.println("boardController > BoardInsertReg에서 에러발생");
			e.printStackTrace();
		}
		return insert_cnt;
	}
}

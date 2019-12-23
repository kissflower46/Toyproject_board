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
		try {
			System.out.println(boardDTO.getTitle());
			System.out.println(boardDTO.getContents());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}

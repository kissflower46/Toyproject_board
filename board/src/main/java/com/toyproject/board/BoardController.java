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
		logger.info("BoardList");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_list");
		return mav;
	}
	
	@RequestMapping(value="/board_insert")
	public ModelAndView BoardInsert() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_insert");
		return mav;
	}
	
	@RequestMapping(value="/board_insertReg")
	public int BoardInsertReg(BoardDTO boardDTO) {
		logger.info("boardinsertReg");
		int insert_cnt = 0;
		try {
			System.out.println(boardDTO.getTitle());
			insert_cnt = boardService.BoardInsertReg(boardDTO);
			System.out.println("Controller무사통과");
		} catch (Exception e) {
			System.out.println("여기 들어온다고? 1");
			e.printStackTrace();
			System.out.println("여기 들어온다고? 2");
		}
		System.out.println("도데체 뭔에러냐");
		return insert_cnt;
	}
}

package com.toyproject.board;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		try {
			List<Map<String, String>> boardList = boardService.BoardList();
			mav.addObject("boardList", boardList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/board_insert")
	public ModelAndView BoardInsert() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_insert");
		return mav;
	}
	
	@RequestMapping(value="/board_insertReg",method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int BoardInsertReg(BoardDTO boardDTO) {
		logger.info("boardinsertReg");
		int insert_cnt = 0;
		try {
			insert_cnt = boardService.BoardInsertReg(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insert_cnt;
	}
	
	@RequestMapping(value="/boardDetail")
	public ModelAndView boardDetail(@RequestParam("board_no") int board_no) {
		logger.info("BoardDetail");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_detail");
		try {
			BoardDTO board_detail = boardService.Board_detail(board_no);
			mav.addObject("board_detail", board_detail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/board_update")
	public ModelAndView board_update(@RequestParam("board_no") int board_no) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_update");
		try {
			BoardDTO board_detail = boardService.Board_detail(board_no);
			mav.addObject("board_detail", board_detail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/board_updateReg",method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int board_updateReg(BoardDTO boardDTO) {
		logger.info("updateReg");
		int update_cnt = 0;
		try {
			update_cnt = boardService.BoardUpdateReg(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update_cnt;
	}
	
	@RequestMapping(value="/board_del",method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int board_del(@RequestParam("board_no") int board_no) {
		logger.info("board_del");
		int delete_cnt = 0;
		try {
			delete_cnt = boardService.BoardDelete(board_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return delete_cnt;
	}
}

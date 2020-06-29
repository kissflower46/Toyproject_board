package com.toyproject.board;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value="/",method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	public ModelAndView BoardList() {
		logger.info(" == BoardList == ");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_list");
		try {
			List<BoardDTO> boardList = boardService.BoardList();
			mav.addObject("boardList", boardList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/board_insert",method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	public String BoardInsert() {
		logger.info("board_insert");
		return "board/board_insert";
	}
	
	@RequestMapping(value="/board_insertReg",method=RequestMethod.POST)
	public String BoardInsertReg(@ModelAttribute BoardDTO boardDTO) {
		logger.info("boardinsertReg");
		try {
			boardService.BoardInsertReg(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/boardDetail",method=RequestMethod.GET, produces="application/json;charset=UTF-8")
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
	
	@RequestMapping(value="/board_update",method=RequestMethod.GET, produces="application/json;charset=UTF-8")
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
	public String board_updateReg(@ModelAttribute BoardDTO boardDTO) {
		logger.info("updateReg");
		int update_cnt = 0;
		try {
			update_cnt = boardService.BoardUpdateReg(boardDTO);
			
			System.out.println(update_cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/boardDetail?board_no="+boardDTO.getBoard_no();
	}
	
	@RequestMapping(value="/board_del",method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public String board_del(@RequestParam("board_no") int board_no) {
		logger.info("board_del");
		int delete_cnt = 0;
		try {
			System.out.println(board_no);
			delete_cnt = boardService.BoardDelete(board_no);
			System.out.println(delete_cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}

package com.prac.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.prac.boot3.util.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {
   
   @Autowired
   BoardService boardService;
   
   @ModelAttribute("board")
   public String getBoard() {
      return "board";
   }

   @GetMapping("list")
   public ModelAndView getList(Pager pager)throws Exception{
      ModelAndView mv = new ModelAndView();
      List<BoardVO> ar = boardService.getList(pager);
      
      mv.addObject("list",ar);
      mv.setViewName("board/list");
      mv.addObject("pager",pager);   
      

      return mv;
   }
   @GetMapping("add")
   public ModelAndView setAdd(BoardVO boardVO, ModelAndView mv)throws Exception{
      
      mv.setViewName("board/add");
      
      return mv;
   }
   @PostMapping("add")
   public String setAdd(BoardVO boardVO,MultipartFile[] files ) throws Exception{
      //업로드시 파일명 출력
	   for(MultipartFile f : files) {
    	  System.out.println(f.getOriginalFilename());
      }
	   
	   int result = boardService.setAdd(boardVO);
      return "redirect:./list";
   }
   
}

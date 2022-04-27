package com.prac.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.prac.boot3.util.FileVO;
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
   @GetMapping("summerFileDelete")
   public ModelAndView setSummerFileDelete(String fileName)throws Exception{
	   ModelAndView mv =new ModelAndView();
	   System.out.println(fileName);
	   boolean result = boardService.setSummerFileDelete(fileName);
	  mv.setViewName("common/result2");
	  mv.addObject("result",result);
	  return mv;
	  
   }
   
   @PostMapping("summerFileUpload")
   public ModelAndView setSummerFileUpload(MultipartFile files)throws Exception{
	   ModelAndView mv =new ModelAndView();
	   String fileName= boardService.setSummerFileUpload(files);
	   System.out.println(fileName);
	   mv.setViewName("common/result2");
	   mv.addObject("result",fileName);
	   return mv;
   }
   
   @GetMapping("fileDown")
   public ModelAndView getFileDown(BoardFilesVO boardFilesVO)throws Exception{
	   ModelAndView mv = new ModelAndView();
	   boardFilesVO=boardService.getFileDetail(boardFilesVO);
	   mv.addObject("fileVO",boardFilesVO);
	   //fileDown 에서 (FileVO)model.get("fileVO"); fileVO로 이용
	   mv.setViewName("fileDown");
	   //Bean(클래스)이름과 동일하게 =fileDown
	   return mv;
	 
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
   @GetMapping("detail")
   public ModelAndView getDetail(BoardVO boardVO) throws Exception{
	   ModelAndView mv =new ModelAndView();
	   boardVO =boardService.getDetail(boardVO);
	   mv.addObject("dto",boardVO);
	   mv.setViewName("board/detail");
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
	   
	   int result = boardService.setAdd(boardVO,files);
      return "redirect:./list";
   }
   @GetMapping("update")
   public ModelAndView setUpdate(BoardVO boardVO)throws Exception{
	   ModelAndView mv =new ModelAndView();
	  boardVO = boardService.getDetail(boardVO);
	   mv.addObject("dto",boardVO);
	   mv.setViewName("board/update");
	   
	   return mv;
   }
   @PostMapping("update")
   public String setUpdate(BoardVO boardVO,Model model)throws Exception{
	   int result=boardService.setUpdate(boardVO);
	   return "redirect:./list";
   }
   @GetMapping("delete")
   public ModelAndView setDelete(BoardVO boardVO)throws Exception{
	   int result= boardService.setDelete(boardVO);
	   ModelAndView mv =new ModelAndView();
	   mv.setViewName("redirect:./list");
	   return mv;
   }
}

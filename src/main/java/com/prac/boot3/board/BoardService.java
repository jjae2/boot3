package com.prac.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.prac.boot3.util.Pager;

@Service
public class BoardService {
   
   @Autowired
   private BoardMapper boardMapper;
   
   //list : getList
   public List<BoardVO> getList(Pager pager)throws Exception{
      pager.makeRow();
      pager.makeNum(boardMapper.getTotalCount(pager));
      
      return boardMapper.getList(pager);
   }


   //insert : setAdd
   public int setAdd(BoardVO boardVO,MultipartFile[] files) throws Exception {
	   //1.file을 hdd에 저장
      return boardMapper.setAdd(boardVO);
   }
   

}
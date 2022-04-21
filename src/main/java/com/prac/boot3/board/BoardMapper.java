package com.prac.boot3.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.prac.boot3.util.Pager;

@Mapper
public interface BoardMapper {
   
   //files
   //detail : getFileDetaile
   public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO) throws Exception;
   //list : getFileList
   public List<BoardFilesVO> getFileList(BoardVO boardVO) throws Exception;
   //insert : setFileAdd
   public int setFileAdd(BoardFilesVO boardFilesVO) throws Exception;
   //delete : setFileDelete
   public int setFileDelete(BoardFilesVO boardFilesVO) throws Exception;
   
   //board
   //detail : getDetail
   public BoardVO getDetail(BoardVO boardVO) throws Exception;

   //list : gettoal
   public Long getTotalCount(Pager pager) throws Exception;
   //list : getList
   public List<BoardVO> getList(Pager pager) throws Exception;
   
   //insert : setAdd
   public int setAdd(BoardVO boardVO) throws Exception;
   
   //update : setUpdate
   public int setUpdate(BoardVO boardVO) throws Exception;
   
   //delete : setDelete
   public int setDelete(BoardVO boardVO)throws Exception;
   
   
}

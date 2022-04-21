package com.prac.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.prac.boot3.util.FileManager;
import com.prac.boot3.util.Pager;

@Service
public class BoardService {
   
   @Autowired
   private BoardMapper boardMapper;
   @Autowired
   private FileManager fileManager;
   
   //file
   public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO)throws Exception{
	   return boardMapper.getFileDetail(boardFilesVO);
   }
  
   //list : getList
   public List<BoardVO> getList(Pager pager)throws Exception{
      pager.makeRow();
      pager.makeNum(boardMapper.getTotalCount(pager));
      
      return boardMapper.getList(pager);
   }
   //detail : getdetail
   
	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		return boardMapper.getDetail(boardVO);
	}
	public int setUpdate(BoardVO boardVO) throws Exception {
		return boardMapper.setUpdate(boardVO);
	}
	public int setDelete(BoardVO boardVO) throws Exception {
		List<BoardFilesVO> ar = boardMapper.getFileList(boardVO);
		int result= boardMapper.setDelete(boardVO);
		 if(result>0) {
			 for(BoardFilesVO dto:ar) {
				 boolean check = fileManager.remove("resources/upload/board/",dto.getFileName());
			 }
		 }
		 return result;
	}

   //insert : setAdd
   public int setAdd(BoardVO boardVO, MultipartFile[] files) throws Exception {
	          int result = boardMapper.setAdd(boardVO);
	          
	         for(MultipartFile mf : files) {
	        	 if(mf.isEmpty()) {
	        		 continue;
	        	 }
	          //1.HDD에 저장
	         String fileName = fileManager.fileSave(mf, "resources/upload/board/");
	         System.out.println(fileName);
//	         //2. DB에 저장
	         BoardFilesVO boardFilesVO = new BoardFilesVO();
	         boardFilesVO.setNum(boardVO.getNum());
	         boardFilesVO.setFileName(fileName);
	         boardFilesVO.setOriName(mf.getOriginalFilename());
//	         
	         boardMapper.setFileAdd(boardFilesVO);
//	         
//	         
	      }
	      
	      return result;
	  }
   
   }
  
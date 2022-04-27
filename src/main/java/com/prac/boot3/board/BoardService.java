package com.prac.boot3.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.prac.boot3.util.FileManager;
import com.prac.boot3.util.Pager;

@Service
@Transactional(rollbackFor=Exception.class)
public class BoardService {
   
   @Autowired
   private BoardMapper boardMapper;
   @Autowired
   private FileManager fileManager;
   
   public boolean setSummerFileDelete(String fileName)throws Exception{
	   fileName=fileName.substring(fileName.lastIndexOf("/")+1);
	   // /resources/upload/board/fb0e1507-652c-4ffd-8d47-795f2ab15f5c_33.jpg
	   // board/ 뒤에 경로를 짜르기위한 방법 /뒤부분부터 나오게 +1
	   return fileManager.remove("/resources/upload/board/",fileName);
   }
   
   
   public String setSummerFileUpload(MultipartFile files)throws Exception{
	   //file hdd에 저장하고 저장된 파일명을 return
	   String fileName= fileManager.fileSave(files,"resources/upload/board");
	   fileName="/resources/upload/board/"+fileName;
	   return fileName;
   }
   
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
	          
	         if(files != null &&result>0) {
	         for(MultipartFile mf : files) {
	        	 if(mf.isEmpty()) {
	        		 continue;
	        	 }
//	        	 if(result>0) {
//	        		 throw new SQLException();
//	        	 }
	          //1.HDD에 저장
	         String fileName = fileManager.fileSave(mf, "resources/upload/board/");
	         System.out.println(fileName);
	         //2. DB에 저장
	         BoardFilesVO boardFilesVO = new BoardFilesVO();
	         boardFilesVO.setNum(boardVO.getNum());
	         boardFilesVO.setFileName(fileName);
	         boardFilesVO.setOriName(mf.getOriginalFilename());	         
	         result= boardMapper.setFileAdd(boardFilesVO);
	         
	         if(result<1) {
	        	 //board table insert 한 것도 rollback
	        	 throw new SQLException();
	                      }
	         }
	      }      
	      return result;
	  }
 
}
  
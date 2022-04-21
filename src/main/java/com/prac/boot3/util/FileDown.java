package com.prac.boot3.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;


@Component//("fd")이라고 쓰면 이름이 fd가 되고, 아무것도 안쓰면 이름은 fileDown이 된다
//Bean의 이름 설정
public class FileDown extends AbstractView{

	@Autowired
	private ServletContext servletContext;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
   		//1. 파일이  저장된  경로 설정
		String path = "resources/upload/";
		path = path + (String)model.get("board"); // @ModelAttribute("board") 다른 클래스마다 이름 다르게
	     path = servletContext.getRealPath(path);
	      
	      //2. 모델에서 파일객체 get
	      FileVO fileVO =(FileVO)model.get("fileVO");
	      //path = path+boardFileVO.getFileName();
	      
	      //3. 위의 정보를 담는 파일 객체 생성
	      File file = new File(path, fileVO.getFileName());
	      
	      //한글 처리
	      response.setCharacterEncoding("UTF-8");
	      
	      //총 파일의 크기
	      response.setContentLengthLong(file.length());
	      
	      //다운로드시 파일 이름을 인코딩 처리
	      String fileName = URLEncoder.encode(fileVO.getOriName(), "UTF-8");
	      
	      //header 설정
	      response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"" );
	      response.setHeader("Content-Transfer-Encoding", "binary");
	      
	      //HDD에서 파일을 읽고
	      FileInputStream fi = new FileInputStream(file);
	      //Client로 전송 준비
	      OutputStream os = response.getOutputStream();
	      
	      //전송
	      FileCopyUtils.copy(fi, os);
	      
	      os.close();
	      fi.close();
	   }   

	}

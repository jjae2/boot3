package com.prac.boot3.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	@Autowired
	private ServletContext servletContext;
	
	//삭제
	 public boolean remove(String path, String fileName)throws Exception{
		   //파일을 HDD에서 삭제
		   //저장된 폴더명,저장된 파일명
		   path=servletContext.getRealPath(path);
		   File file = new File(path, fileName);
		  return file.delete();
	   }
	
	//저장
	public String fileSave(MultipartFile mf,String path)throws Exception{
		path=servletContext.getRealPath(path);
		System.out.println(path);
	File file= new File(path);
	if(!file.exists()) {
		file.mkdirs();
	}
	String fileName=UUID.randomUUID().toString(); //uuid 랜덤생성
	fileName= fileName+"_"+mf.getOriginalFilename(); //확장자생성
			
	file= new File(file,fileName);
	mf.transferTo(file);
	return fileName;
	}
	
}

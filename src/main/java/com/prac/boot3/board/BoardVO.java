package com.prac.boot3.board;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private Long num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private Long hit;
	private Long ref;
	private Long step;
	private Long depth;
	private Long category;
	
	private List<BoardFilesVO> boardFilesVO;
}

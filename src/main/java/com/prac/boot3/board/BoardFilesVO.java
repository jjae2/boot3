package com.prac.boot3.board;

import com.prac.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BoardFilesVO extends FileVO {
	
	private Long num;

}

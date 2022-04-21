package com.prac.boot3.member;

import com.prac.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MemberFilesVO extends FileVO{
	private String id;

}

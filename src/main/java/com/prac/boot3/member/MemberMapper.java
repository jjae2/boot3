package com.prac.boot3.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
	public MemberVO getLogin(MemberVO memberVO)throws Exception;
	public MemberVO getMypage(MemberVO memberVO)throws Exception;
	public int setJoin(MemberVO memberVO)throws Exception;
	public int setUpdate(MemberVO memberVO)throws Exception;
	public int setDelete(MemberVO memberVO)throws Exception;
	public int setRoleAdd(Map<String, String> map)throws Exception;
	public MemberVO getFindId(MemberVO memberVO)throws Exception;
	//파일
	public int setFileAdd(MemberFilesVO memberFilesVO)throws Exception;
	public MemberFilesVO getFileList(MemberVO memberVO)throws Exception;
}

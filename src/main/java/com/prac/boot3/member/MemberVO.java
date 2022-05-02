package com.prac.boot3.member;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private MemberFilesVO memberFilesVO;
	private List<RoleVO> roleVOs;
}

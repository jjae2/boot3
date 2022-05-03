package com.prac.boot3.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class MemberVO {
	@NotBlank
	private String id;
	@Size(min=3,max=8)	
	private String pw;
	private String checkPw;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	private String phone;
	private MemberFilesVO memberFilesVO;
	private List<RoleVO> roleVOs;
}

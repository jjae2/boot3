package com.prac.boot3.member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberMapperTest {
	@Autowired
	private MemberMapper memberMapper;
	
	 @Test
	void fileDetailtest() throws Exception {
		MemberVO memberVO =new MemberVO();
		memberVO.setId("id2");
		memberVO.setPw("pw2");
		memberVO=memberMapper.getMypage(memberVO);
		assertNotNull(memberVO);
	}
	//@Test
 void joinTest()throws Exception{
		MemberVO memberVO =new MemberVO();
		memberVO.setId("id2");
		memberVO.setPw("pw2");
		memberVO.setName("name2");
		memberVO.setEmail("email2");
		memberVO.setPhone("phone2");
		int result= memberMapper.setJoin(memberVO);
		assertEquals(1, result);
	}
	//@Test
void mypageTest() throws Exception{
		MemberVO memberVO =new MemberVO();
		memberVO.setId("id1");
		memberVO.setPw("pw1");
		memberVO=memberMapper.getMypage(memberVO);
		assertNotNull(memberVO);
	}
//@Test
void updateTest()throws Exception{
	MemberVO memberVO =new MemberVO();
	memberVO.setId("id1");
	memberVO.setPw("pw1");
	memberVO.setName("name1_1");
	memberVO.setEmail("email1_1");
	memberVO.setPhone("phone1_1");
	
	int result= memberMapper.setUpdate(memberVO);
	assertEquals(1, result);
}
//@Test
void deleteTest()throws Exception{
	MemberVO memberVO =new MemberVO();
	memberVO.setId("id1");
	memberVO.setPw("pw1");
	int result= memberMapper.setDelete(memberVO);
	assertEquals(1, result);
}
//@Test
void setFileAddTest() throws Exception {
	MemberFilesVO memberFilesVO = new MemberFilesVO();
	memberFilesVO.setFileName("filename");
	memberFilesVO.setOriName("oriname");
	memberFilesVO.setId("id2");
	int result = memberMapper.setFileAdd(memberFilesVO);
	assertEquals(1, result);
}

}

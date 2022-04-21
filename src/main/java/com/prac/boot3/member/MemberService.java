package com.prac.boot3.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.prac.boot3.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager;

	public MemberVO getLogin(MemberVO memberVO) throws Exception {
		return memberMapper.getLogin(memberVO);
	}

	public MemberVO getMypage(MemberVO memberVO) throws Exception {
		return memberMapper.getMypage(memberVO);
	}

	public int setJoin(MemberVO memberVO, MultipartFile profile) throws Exception {
		int result = memberMapper.setJoin(memberVO);
		// 1.HDD에 저장
		String fileName = fileManager.fileSave(profile, "resources/upload/member/");
		// 2.DB에 저장
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFileName(fileName);
		memberFilesVO.setOriName(profile.getOriginalFilename());
		memberMapper.setFileAdd(memberFilesVO);
		return result;

	}

	public int setUpdate(MemberVO memberVO) throws Exception {
		return memberMapper.setUpdate(memberVO);
	}

	public int setDelete(MemberVO memberVO) throws Exception {
		MemberFilesVO memberFilesVO = memberMapper.getFileList(memberVO);
		int result = memberMapper.setDelete(memberVO);
		if (result == 1) {
			boolean check = fileManager.remove("resources/upload/member/", memberFilesVO.getFileName());
		}

		return result;
	}

	public int setFileAdd(MemberFilesVO memberFilesVO) throws Exception {
		return memberMapper.setFileAdd(memberFilesVO);
	}

}

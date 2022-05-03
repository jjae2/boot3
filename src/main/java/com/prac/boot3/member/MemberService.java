package com.prac.boot3.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.prac.boot3.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager;
	
	//properties 파일의 member.role.member 속성값을 반환해서 갖고온다
	@Value("${member.role.member}")
	private String memberRole;
	
	//사용자 정의 검증 메서드 선언
	public boolean memberError(MemberVO memberVO, BindingResult bindingResult)throws Exception{
		boolean check=false;
		//check= false :: 검증 성공 (error 없음)
		//check= true :: 검증 실패 (error 있음)
		
		//1.annotation 기본 검증 결과
		check = bindingResult.hasErrors();
		//2. password 일치하는 지 수동 검증
		if(!memberVO.getPw().equals(memberVO.getCheckPw())) {
			check=true;
			bindingResult.rejectValue("checkPw", "member.password.notEqul");
		}
		//3. id 일치하는 지 수동 검증
		MemberVO idCheck=memberMapper.getId(memberVO);
		if(idCheck!=null) {
			check=true;
			bindingResult.rejectValue("id", "member.id.notEqul");
		}
		return check;
	}
	
	public MemberVO getFindId(MemberVO memberVO)throws Exception{
		return memberMapper.getFindId(memberVO);
	}
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception {
		return memberMapper.getLogin(memberVO);
	}

	public MemberVO getMypage(MemberVO memberVO) throws Exception {
		return memberMapper.getMypage(memberVO);
	}

	public int setJoin(MemberVO memberVO, MultipartFile profile) throws Exception {
		int result = memberMapper.setJoin(memberVO);
		Map<String, String> map = new HashMap<>();
		map.put("id", memberVO.getId()); //map에서는 put
		map.put("roleName", memberRole);
		
		result = memberMapper.setRoleAdd(map);
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

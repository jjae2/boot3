package com.prac.boot3.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("join")
	public void setJoin() throws Exception {
	}

	@PostMapping("join")
	public String setJoin(MemberVO memberVO, MultipartFile profile) throws Exception {
		int result = memberService.setJoin(memberVO, profile);
		return "redirect:../";
	}

	@GetMapping("login")
	public void getLogin(Model model, @CookieValue(value = "remember", defaultValue = "") String rememberId)
			throws Exception {
	}

	@PostMapping("login")
	public String getLogin(HttpSession session, MemberVO memberVO, String remember, Model model,
			HttpServletResponse response) throws Exception {
		if (remember != null && remember.equals("1")) {
			// 쿠키생성
			Cookie cookie = new Cookie("remember", memberVO.getId());
			cookie.setPath("/");
			cookie.setMaxAge(-1);
			// 응답
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		memberVO = memberService.getLogin(memberVO);
		String message = "로그인 실패 하였습니다.";
		String p = "./login";
		if (memberVO != null) {
			session.setAttribute("member", memberVO);
			message = "로그인 성공 하였습니다.";
			p = "../";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", p);
		String path = "common/result";
		return path;
	}

	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}

	@GetMapping("mypage")
	public ModelAndView getMypage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		memberVO = memberService.getMypage(memberVO);
		mv.addObject("dto", memberVO);
		mv.setViewName("./member/mypage");
		return mv;
	}

	@GetMapping("update")
	public ModelAndView SetUpdate(MemberVO memberVO, ModelAndView mv) throws Exception {
		memberVO = memberService.getMypage(memberVO);
		mv.addObject("dto", memberVO);
		mv.setViewName("./member/update");
		return mv;
	}

	@PostMapping("update")
	public String SetUpdate(MemberVO memberVO, HttpSession session) throws Exception {
		int result = memberService.setUpdate(memberVO);
		return "redirect:./mypage";
	}

	@GetMapping("delete")
	public ModelAndView setDelete(MemberVO memberVO, HttpSession session) throws Exception {
		int result = memberService.setDelete(memberVO);
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}

}

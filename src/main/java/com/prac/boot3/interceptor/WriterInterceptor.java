package com.prac.boot3.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.prac.boot3.board.BoardMapper;
import com.prac.boot3.board.BoardVO;
import com.prac.boot3.member.MemberVO;

@Component
public class WriterInterceptor implements HandlerInterceptor {
	@Autowired
	private BoardMapper boardMapper;
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		MemberVO memberVO =(MemberVO)request.getSession().getAttribute("member");
//		Map<String, Object> map= modelAndView.getModel();//model 먼저 꺼낸다
//		BoardVO boardVO =(BoardVO)map.get("dto");
//		if(!boardVO.getWriter().equals(memberVO.getId())) {
////			modelAndView.setViewName("redirect:./list");
//			modelAndView.addObject("msg","작성자만 가능합니다.");
//			modelAndView.addObject("path","./list");
//			modelAndView.setViewName("common/getResult");
//		}
//	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 작성자와 로그인 한 사용자의 id가 일치하면 통과.
		// 일치하지 않으면 list로 redirect
		String num = request.getParameter("num");
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(Long.parseLong(num));
		boardVO = boardMapper.getDetail(boardVO);
		MemberVO memberVO = (MemberVO) request.getSession().getAttribute("member");
		// boolean check=false;
		if (boardVO.getWriter().equals(memberVO.getId())) {
			// check = true;
			return true;
		} else {// 반복문이 아니기때문에 if else 사용 가능하다.
			response.sendRedirect("./list");

			return false;
		}
	}
}

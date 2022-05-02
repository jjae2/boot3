package com.prac.boot3.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.prac.boot3.member.MemberVO;
import com.prac.boot3.member.RoleVO;

@Component
public class AdminInterceptor implements HandlerInterceptor {
	@Value("${member.role.admin}")
	private String roleName;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check = false;
	      // 로그인 한 사용자의 ROLE이 ROLE_ADMIN이라면 통과 아니면 거절
	      HttpSession session = request.getSession();
	      MemberVO memberVO = (MemberVO) session.getAttribute("member");
	      if(memberVO !=null) {
	      for (RoleVO roleVO : memberVO.getRoleVOs()) {
	         if (roleVO.getRoleName().equals(roleName)) {  
	            check = true;
	         		}
	      		}
	      }
	      //check가 true면 통과
	      //check가 false면 거절 : servlet코드사용
	      if(!check){      //check가 false라면 라는 의미
	      //redirect:response.sendRedirect("url주소")
	      //forward
	      
	      //mv.addObject("키",value)
	      request.setAttribute("msg", "권한이 없습니다.");
	      request.setAttribute("path", "../");
	     
	      //mv.setViewName();
	      //WEB-INF/views 경로와 .jsp 까지 직접작성
	      RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/getResult.jsp");
	      view.forward(request, response);    //실제 보내는것         // -> check가 false 면 얘네들을 하자
	      
	      }
	      return check;

	   }
	}

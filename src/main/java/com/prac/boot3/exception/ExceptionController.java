package com.prac.boot3.exception;



import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {
	
	
	//예외처리 메서드
	@ExceptionHandler(BindException.class)
	public ModelAndView ex1(Exception e) {
		ModelAndView mv = new ModelAndView();
		System.out.println(e.getMessage());
		System.out.println("=============");
		e.printStackTrace();
		System.out.println("예외 발생 처리");
		mv.addObject("msg","죄송합니다.");
		mv.addObject("path","../");
		mv.setViewName("common/getResult");
		return mv;
	}
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView ex2() {
		ModelAndView mv = new ModelAndView();
		System.out.println("NullPointer 예외 발생 처리");
		mv.addObject("msg","죄송합니다.");
		mv.addObject("path","../");
		mv.setViewName("common/getResult");
		return mv;
	}
	@ExceptionHandler(Exception.class)//부모 타입 Exception
	public ModelAndView ex3() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Exception 예외 발생 처리");
		mv.setViewName("error/error");
		return mv;
	}
	@ExceptionHandler(Throwable.class)//최상위 부모 타입 Exception
	public ModelAndView ex4() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Exception 예외 발생 처리");
		mv.setViewName("error/error");
		return mv;
	}
	
	//400
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView ex5() {
		ModelAndView mv = new ModelAndView();
		System.out.println("4XX 예외 발생 처리");
		mv.addObject("message","페이지를 찾을 수 없습니다.");
		mv.setViewName("error/error");
		return mv;
	}
}

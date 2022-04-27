package com.prac.boot3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class Payment {
	@Around("execution(* com.prac.boot3.aop.Transfer.*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint)throws Throwable {
		//join point 핵심 로직 메서드( bus,subway)
		System.out.println("탑승 전 카드 체크체크");
		
		Object obj=joinPoint.proceed();
		//obj는 핵심로직 메서드가 리턴하는 Data
		
		System.out.println("하차 시 카드 체크체크");
		
		return obj;
	}
	
	@Before("execution(* com.prac.boot3.board.BoardService.get*(..))")
	public void info() {
		System.out.println("== select ==");
	}
	@AfterReturning("execution(* com.prac.boot3.aop.Transfer.*())")
	public void afterReturning() {
		System.out.println("==  afterReturning  ==");
	}
	@AfterThrowing("execution(* com.prac.boot3.aop.Transfer.*())")
	public void afterThrowing() {
		System.out.println("==  afterThrowing  ==");
	}
	@After("execution(* com.prac.boot3.board.BoardService.get*(..))")
	public void after() {
		System.out.println("after == returning + throwing");
	} 
	/*
	 * @Around("execution(* com.prac.boot3.board.BoardService.get*(..))") public
	 * void around() { System.out.println("around == before + after"); }
	 */
}

package com.prac.boot3.aop;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	public void bus() {
		System.out.println("bus 타기");
	}
	public void subway() {
		System.out.println("subway 타기");
	}
}

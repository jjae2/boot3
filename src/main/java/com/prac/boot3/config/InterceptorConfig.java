package com.prac.boot3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.prac.boot3.interceptor.AdminInterceptor;
import com.prac.boot3.interceptor.BoardInterceptor;
import com.prac.boot3.interceptor.SellerInterceptor;
import com.prac.boot3.interceptor.WriterInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	private SellerInterceptor sellerInterceptor;
	@Autowired
	private AdminInterceptor adminInterceptor;	
	@Autowired
	private BoardInterceptor boardInterceptor;
	@Autowired
	private WriterInterceptor writerInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//적용할 interceptor를 등록
		registry.addInterceptor(sellerInterceptor)
		//Interceptor를 사용할 URL
		.addPathPatterns("/product/manage");
		//.addPathPatterns("") 추가
		//제외할 URL
		//.excludePathPatterns
		//추가로 다른 interceptor 추가
		//registry.addInterceptor(인터셉터)
		//.addPathPatterns("경로");
		registry.addInterceptor(adminInterceptor)
		.addPathPatterns("/admin/manage");
		
		registry.addInterceptor(boardInterceptor)
		.addPathPatterns("/board/*")
		.excludePathPatterns("/board/list");

		registry.addInterceptor(writerInterceptor)
		.addPathPatterns("/board/update")
		.addPathPatterns("/board/delete");
		
		
		//WebMvcConfigurer.super.addInterceptors(registry);
	}
}

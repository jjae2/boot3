package com.prac.boot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableAspectJAutoProxy
//@EnableScheduling
@SpringBootApplication
public class Boot3Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot3Application.class, args);
	}

}

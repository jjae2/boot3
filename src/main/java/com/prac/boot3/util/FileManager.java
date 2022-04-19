package com.prac.boot3.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileManager {
	@Autowired
	private ServletContext servletContext;
	
}

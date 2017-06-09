package com.mycompany.myapp.controller;

import java.io.File;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(){
		
		//System.out.println("home()");
		return "home";
		//앞에 WEB-INF/views뒤에 .jsp 생략
	}
	
	/*
	@RequestMapping("/html/gallery")
	public String gallery() {
		return "html/gallery";
	}
	*/
	
	
	
	
}

package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Exam01HomeController {

	@RequestMapping("/") // 컨텍스트 다음의 /를 의미
	public String home(){
		System.out.println("home()");
		return "home";
	}
	
	

	
	
	
	

}

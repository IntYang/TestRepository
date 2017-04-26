package com.mycompany.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {

	@RequestMapping("/") // 컨텍스트 다음의 /를 의미
	public String home(){
		System.out.println("home()");
		return "home";
	}
	
	@RequestMapping("/html")
	public String html(){
		return "html";
	}
	//2017.04.26 수업 내용
	@RequestMapping("/css/exam01")
	public String cssExam01(){
		return "css/exam01"; //WEB-INF/views/css/exam01.jsp임 원래
	}
	
	
}

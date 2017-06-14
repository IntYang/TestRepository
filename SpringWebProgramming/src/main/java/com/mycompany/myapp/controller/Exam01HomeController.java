package com.mycompany.myapp.controller;


// SLF4J 인터페이스를 공통 규격으로 규정하기 때문에 slf4j 것을 임포트 할 것
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam01HomeController { 
	// 로거가 되도록 설정
	// static 객체마다 필드를 생성 안하게 하려고
	// final 한번 값이 대입되면 안바뀌게 하려고
	private static final Logger lOGGER = LoggerFactory.getLogger(Exam01HomeController.class);
	
	@RequestMapping("/")
	public String home(){
		lOGGER.info("/요청 처리함");
		//System.out.println("home()");
		return "home";
		//앞에 WEB-INF/views뒤에 .jsp 생략
	}			
	
}

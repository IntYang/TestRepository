package com.mycompany.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam14AopController {
	@RequestMapping("/aop/exam01")
	public String exam01(HttpSession session){ // 로그인 필요없이 실행하는 메소드
		session.setAttribute("mid", "xxxx");
		return "aop/exam01";
	}
	
	@RequestMapping("/aop/exam02Write")
	public String exam02Write(){ // 반드시 로그인이 되어야 실행한다
		return "aop/exam02";
	}
	
	@RequestMapping("/aop/exam02Update")
	public String exam02Update(){ // 반드시 로그인이 되어야 실행한다
		return "aop/exam02";
	}
}

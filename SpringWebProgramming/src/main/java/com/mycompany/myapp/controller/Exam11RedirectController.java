package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam11RedirectController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam11RedirectController.class);
	
	@RequestMapping("/redirect/write")
	public String write(){
		LOGGER.info("게시물 저장");
		return "redirect:/redirect/list"; // 클라이언트한테 재요청할 때 'redirect:/(경로~~)'
	}
	
	@RequestMapping("/redirect/list")
	public String list(){
		LOGGER.info("게시물 목록");
		return "redirect/list";
	}
}

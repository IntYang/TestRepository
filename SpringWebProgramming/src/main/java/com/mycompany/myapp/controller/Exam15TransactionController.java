package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exception.NoAccountException;
import com.mycompany.myapp.service.Exam15Service;

@Controller // 예외처리는 컨트롤러에서
public class Exam15TransactionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam15TransactionController.class); 
	
	@Autowired
	private Exam15Service service;
	
	
	@RequestMapping(value="/transaction/exam01", method=RequestMethod.GET)
	public String exam01Get(){ // 계좌이체 양식 제공
		return "transaction/exam01";
	}
	
	@RequestMapping(value="/transaction/exam01", method=RequestMethod.POST)
	public String exam01Post(String fromAno, String toAno, int amount){ // summit 후 실제 계좌이체 결과 처리
		service.transfer(fromAno, toAno, amount);
		return "redirect:/";
	}
	
	// 해당 컨트롤러에서 처리하는 방법1
	@ExceptionHandler // 예외를 처리하는 용도
	public String handleNoAccountException(NoAccountException e, Model model){
		LOGGER.info("실행");
		model.addAttribute("reason",e.getMessage()); // 메시지는 서비스에서 throw new  ("메시지내용")
		return "transaction/exam02";
	}
	

	
	
	
}

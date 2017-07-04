package com.mycompany.myapp.controller;

import java.io.File;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/http")
public class HttpController {
	@RequestMapping("/exam01")
	public String exam01(
			@RequestParam(defaultValue="0")double thermistor, 
			@RequestParam(defaultValue="0")double photoresistor, 
			Model model) throws Exception{
		Thread.sleep(1000);
		model.addAttribute("thermistor", thermistor);
		model.addAttribute("photoresistor", photoresistor);
		return "http/exam01";
	}
	
	@RequestMapping("/exam02")
	public String exam02(String title, String content, MultipartFile attach, Model model) throws Exception{
		String savedfilename = new Date().getTime() + "-" + attach.getOriginalFilename(); // 중복 방지 위해 시간 붙임
		String savedfilepath = "C:/Temp/" + savedfilename;
		attach.transferTo(new File(savedfilepath));
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		model.addAttribute("originalfilename", attach.getOriginalFilename());
		model.addAttribute("filecontenttype",attach.getContentType());
		model.addAttribute("savedfilename",savedfilename);
		
		return "http/exam02";
	}
	
	
}
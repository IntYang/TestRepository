package com.mycompany.myapp.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.dto.Gallery;
import com.mycompany.myapp.service.GalleryService;


@Controller
public class HomeController {
	
	@Autowired
	private GalleryService service;
	
	//@Autowired
	//private ServletContext servletContext;
	
	
	@RequestMapping("/")
	public String home(Model model){
		
		//System.out.println("home()");
		List<Gallery> list = service.galleryListAll();
		model.addAttribute("list", list);
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

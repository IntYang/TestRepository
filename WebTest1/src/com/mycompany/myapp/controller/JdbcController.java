package com.mycompany.myapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.Gallery;
import com.mycompany.myapp.service.GalleryService;

@Controller
public class JdbcController {
	@Autowired
	private GalleryService service;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/html/gallery")
	public String gallery(Model model){
		List<Gallery> list = service.galleryListAll();
		model.addAttribute("list", list);
		return "html/gallery";
	}
	
	
	@RequestMapping("/html/galleryDetail")
	public String galleryDetail(int gno, Model model){
		Gallery gallery = service.getGallery(gno);
		model.addAttribute("gallery", gallery);
		
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "html/galleryDetail";
	}
	
	
	
	
	/*
	
	@RequestMapping(value="/html/galleryDetail", method = RequestMethod.GET)
	public String galleryDetailGet(){
		
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "/html/galleryDetail";
	}
	
	@RequestMapping(value="/html/galleryDetail", method = RequestMethod.POST)
	public String galleryDetailPost(Gallery gallery) throws Exception{
		
		Gallery gallery = service.getGallery(gno);
		model.addAttribute("gallery", gallery);
		return "/html/galleryDetail";
	}
	
	
	
	/*
	
	@RequestMapping(value="/html/write", method = RequestMethod.GET)
	public String writeGET(int gno, Model model){
		Gallery gallery = service.getGallery(gno);
		model.addAttribute("gallery", gallery);
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "html/write";
		
	}
	
	*/
	/*
	@RequestMapping(value="/html/write", method = RequestMethod.POST)
	public String writePost(Gallery gallery) throws Exception{ // exam05Update의 수정될 사항들 매개변수로 받아야 or 커멘드 객체로 통째로
		// 첨부파일이 변경되었는지 검사
	
		if(!gallery.getattach().isEmpty()){
			
			// 첨부 파일에 대한 정보를 컬럼값으로 설정
			gallery.setOriginalfilename(gallery.getattach().getOriginalFilename());
			gallery.setFilecontent(gallery.getattach().getContentType());
			String fileName = new Date().getTime() +"-" + gallery.getOriginalfilename();
			gallery.setSavedfilename(fileName);
			
			// 첨부파일을 서버 로컬 시스템에 저장
			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			File file = new File(realPath + fileName);
			gallery.getattach().transferTo(file);
			
		}
		
		// 게시물 수정 처리
		service.galleryUpdate(gallery);
		return "/html/write";
	}
	*/
	
	@RequestMapping("/html/file/upload")
	public void fileView(HttpServletResponse response, @RequestHeader("User-Agent") String userAgent, int gno)
			throws IOException {
		// 응답 HTTP 헤더행을 추가
		// 1)파일이름(옵션)
		Gallery gallery = service.getGallery(gno);
		String fileName = gallery.getSavedfilename();
		System.out.println(fileName);
		String encodingFileName;
		if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}

		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		// 2)파일종류(필수)
		response.addHeader("Content-Type", gallery.getFilecontent());
		// 3)파일사이즈(옵션)
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/" + fileName));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));

		// 응답 HTTP 본문에 파일 데이터를 출력
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();

	}
}

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
	public String gallery(@RequestParam(defaultValue="1") int pageNo, Model model){
		
				// 한 페이지를 구성하는 행 수
				int rowsPerPage = 6; // 고정값(개발자가 정함
				// 한 그룹을 구성하는 페이지 수
				int pagesPerGroup = 5; // 고정값
				// 총 행수
				int totalRows = 36;
				// 전체 페이지 수
				int totalPageNo = (totalRows/rowsPerPage) + ((totalRows % rowsPerPage !=0) ? 1:0);
				// 전체 그룹 수
				int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo % pagesPerGroup != 0)?1:0);
				// 현재 그룹 번호
				int groupNo = (pageNo-1)/pagesPerGroup + 1;
				// 현재 그룹의 시작 페이지 번호
				int startPageNo = (groupNo-1)*pagesPerGroup + 1;
				// 현재 그룹의 끝 페이지 번호
				int endPageNo = startPageNo + (pagesPerGroup-1);
				if(groupNo == totalGroupNo){endPageNo = totalPageNo;}
		
		
		
		List<Gallery> list = service.galleryListPage(pageNo,rowsPerPage);
		model.addAttribute("list", list);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		model.addAttribute("pageNo", pageNo);
		
		
		
		
		return "html/gallery";
	}
	
	@RequestMapping(value="/html/galleryWrite", method = RequestMethod.GET)
	public String galleryWriteGet(){
		return "html/galleryWrite";
	}
	

	@RequestMapping(value = "/html/galleryWrite", method = RequestMethod.POST)
	public String galleryWritePost(Gallery gallery) throws Exception {
		if (!gallery.getattach().isEmpty()) {
			gallery.setOriginalfilename(gallery.getattach().getOriginalFilename());
			String originalFileName = gallery.getOriginalfilename();

			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			String fileName = new Date().getTime() + "-" + originalFileName;
			File file = new File(realPath + fileName);
			gallery.getattach().transferTo(file);
			gallery.setSavedfilename(fileName);
			gallery.setFilepath("/WEB-INF/upload/" + originalFileName);
		}
		service.galleryWrite(gallery);
		return "redirect:gallery";
	}

	
	@RequestMapping("/html/galleryDetail")
	public String galleryDetail(int gno, Model model){
		Gallery gallery = service.getGallery(gno);
		model.addAttribute("gallery", gallery);
		
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "html/galleryDetail";
	}

	

	@RequestMapping(value="/html/galleryUpdate", method = RequestMethod.GET)
	public String galleryUpdateGet(int gno, Model model){
		Gallery gallery = service.getGallery(gno);
		model.addAttribute("gallery", gallery);
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "html/galleryUpdate";
		
	}
	
	@RequestMapping(value="/html/galleryUpdate", method = RequestMethod.POST)
	public String galleryUpdatePost(Gallery gallery) throws Exception{ // exam05Update의 수정될 사항들 매개변수로 받아야 or 커멘드 객체로 통째로
		// 첨부파일이 변경되었는지 검사
		
		if(!gallery.getattach().isEmpty()){
			
			// 첨부 파일에 대한 정보를 컬럼값으로 설정
			gallery.setOriginalfilename(gallery.getattach().getOriginalFilename());
			gallery.setFilecontent(gallery.getattach().getContentType());
			String fileName = new Date().getTime() +"-" +gallery.getOriginalfilename();
			gallery.setSavedfilename(fileName);
			
			// 첨부파일을 서버 로컬 시스템에 저장
			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			File file = new File(realPath + fileName);
			gallery.setFilepath("/WEB-INF/upload/" + gallery.getOriginalfilename());
			gallery.getattach().transferTo(file);
			
		}
		
		// 게시물 수정 처리
		service.galleryUpdate(gallery);
		return "redirect:galleryDetail?gno="+gallery.getGno();
	}
	
	@RequestMapping("/html/galleryDelete")
	public String galleryDelete(int gno){
		service.galleryDelete(gno);
		return "redirect:gallery";
	}
	
	
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

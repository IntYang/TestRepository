package com.mycompany.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;
import com.mycompany.myapp.service.Exam12Service;

@Controller
public class Exam12DBController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DBController.class);
	
	//@Autowired
	@Resource(name="exam12ServiceImpl3")
	private Exam12Service service;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/jdbc/exam01")
	public String exam01(){
		Exam12Board board = new Exam12Board();
		board.setBtitle("제목");
		board.setBcontent("내용");
		board.setBwriter("헝그리");
		board.setBpassword("12345");
		board.setBoriginalfilename("a.png");
		board.setBsavedfilename("a.png");
		board.setBfilecontent("image/png");
		//.insert1(board);
		
		service.boardWrite(board);
		return "redirect:/";
	}
	
	@RequestMapping(value="/jdbc/exam02", method = RequestMethod.GET)
	public String exam02Get(){
		return "jdbc/exam02";
	}
	
//	@RequestMapping(value="/jdbc/exam03", method=RequestMethod.POST)
//	public String exam02Post(String btitle, String bwriter, String bpassword, String bcontent,MultipartFile battach){
//		LOGGER.info("실행됨");
//		LOGGER.info("btitle: " + board.getBtitle());
//		LOGGER.info("bwriter: " + board.getBwriter());
//		LOGGER.info("첨부파일명: " + battach.getOriginalFilename());
//		return "redirect:/";
//	}
	
	@RequestMapping(value="/jdbc/exam02", method=RequestMethod.POST)
	public String exam02Post(Exam12Board board) throws Exception{
	//	LOGGER.info("실행됨");
		//LOGGER.info("btitle: " + board.getBtitle());
//		LOGGER.info("bwriter: " + board.getBwriter());
//		LOGGER.info("첨부파일명: " + board.getBattach().getOriginalFilename());
		
		// 첨부 파일에 대한 정보를 컬럼값으로 설정
		board.setBoriginalfilename(board.getBattach().getOriginalFilename());
		board.setBfilecontent(board.getBattach().getContentType());
		String fileName = new Date().getTime() +"-" +board.getBoriginalfilename();
		board.setBsavedfilename(fileName);
		
		// 첨부파일을 서버 로컬 시스템에 저장
		String realPath = servletContext.getRealPath("/WEB-INF/upload/");
		File file = new File(realPath + fileName);
		board.getBattach().transferTo(file);
		
		//LOGGER.info(realPath);
		// 서비스 객체에 요청 처리 요청
		service.boardWrite(board);
		return "redirect:/jdbc/exam05";
	}
	
	/*
	@RequestMapping(value="/jdbc/exam03", method = RequestMethod.GET)
	public String exam03Get(){
		return "jdbc/exam03";
	}
	
	
	@RequestMapping(value="/jdbc/exam03", method=RequestMethod.POST)
	public String exam03Post(Exam12Member member) throws Exception{
	
		// 첨부 파일에 대한 정보를 컬럼값으로 설정
		member.setMoriginalfilename(member.getMattach().getOriginalFilename());
		member.setMfilecontent(member.getMattach().getContentType());
		String fileName = new Date().getTime() +"-" +member.getMoriginalfilename();
		member.setMsavedfilename(fileName);
		
		// 첨부파일을 서버 로컬 시스템에 저장
		String realPath = servletContext.getRealPath("/WEB-INF/upload/");
		File file = new File(realPath + fileName);
		member.getMattach().transferTo(file);
		
		//LOGGER.info(realPath);
		// 서비스 객체에 요청 처리 요청
		service.memberJoin(member);
		return "redirect:/";
	}
	*/
	
	@RequestMapping("/jdbc/exam04")
	public String exam04(Model model){
		List<Exam12Board> list = service.boardListAll();
		model.addAttribute("list", list);
		return "jdbc/exam04";
	}
	
	@RequestMapping("/jdbc/exam05")
	public String exam05(@RequestParam(defaultValue="1") int pageNo, Model model){
		// 한 페이지를 구성하는 행 수
		int rowsPerPage = 10; // 고정값(개발자가 정함
		// 한 그룹을 구성하는 페이지 수
		int pagesPerGroup = 7; // 고정값
		// 총 행수
		int totalRows = 100;
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
		// 현재 페이지의 행의 데이터 가져오기
		List<Exam12Board> list = service.boardListPage(pageNo, rowsPerPage);
		
		// View(JSP)로 넘겨줄 데이터
		model.addAttribute("list", list);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		model.addAttribute("pageNo", pageNo);
		
		
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "jdbc/exam05";
	}
	
	@RequestMapping("/jdbc/exam05Detail")
	public String exam05Detail(int bno, Model model){
		Exam12Board board = service.getBoard(bno);
		model.addAttribute("board", board);
		
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "jdbc/exam05Detail";
	}
	
	@RequestMapping("/jdbc/exam05CheckBpassword")
	public String exam05CheckBpassword(int bno, String bpassword,Model model){
		String result = service.boardCheckBpassword(bno, bpassword);
		model.addAttribute("result", result);
		
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "jdbc/exam05CheckBpassword";
	}
	

	@RequestMapping(value="/jdbc/exam05Update", method = RequestMethod.GET)
	public String exam05UpdateGet(int bno, Model model){
		Exam12Board board = service.getBoard(bno);
		model.addAttribute("board", board);
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "jdbc/exam05Update";
		
	}
	
	@RequestMapping(value="/jdbc/exam05Update", method = RequestMethod.POST)
	public String exam05UpdatePost(Exam12Board board) throws Exception{ // exam05Update의 수정될 사항들 매개변수로 받아야 or 커멘드 객체로 통째로
		// 첨부파일이 변경되었는지 검사
		LOGGER.info(String.valueOf(board.getBattach().isEmpty()));
		if(!board.getBattach().isEmpty()){
			
			// 첨부 파일에 대한 정보를 컬럼값으로 설정
			board.setBoriginalfilename(board.getBattach().getOriginalFilename());
			board.setBfilecontent(board.getBattach().getContentType());
			String fileName = new Date().getTime() +"-" +board.getBoriginalfilename();
			board.setBsavedfilename(fileName);
			
			// 첨부파일을 서버 로컬 시스템에 저장
			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			File file = new File(realPath + fileName);
			board.getBattach().transferTo(file);
			
		}
		
		// 게시물 수정 처리
		service.boardUpdate(board);
		return "redirect:/jdbc/exam05Detail?bno=" + board.getBno();
	}
	@RequestMapping("/jdbc/exam05Delete")
	public String exam05Delete(int bno){
		service.boardDelete(bno);
		return "redirect:/jdbc/exam05";
	}

	
	
	
//	@RequestMapping(value="/jdbc/exam03", method=RequestMethod.POST)
//	public String exam02Post(String btitle, String bwriter, String bpassword, String bcontent,MultipartFile battach){
//		LOGGER.info("실행됨");
//		LOGGER.info("btitle: " + board.getBtitle());
//		LOGGER.info("bwriter: " + board.getBwriter());
//		LOGGER.info("첨부파일명: " + battach.getOriginalFilename());
//		return "redirect:/";
//	}
	
	
	
	@RequestMapping("/jdbc/exam06")
	public String exam06(@RequestParam(defaultValue="1") int pageNo, Model model){
		// 한 페이지를 구성하는 행 수
		int rowsPerPage = 10; // 고정값(개발자가 정함
		// 한 그룹을 구성하는 페이지 수
		int pagesPerGroup = 7; // 고정값
		// 총 행수
		int totalRows = 100;
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
		// 현재 페이지의 행의 데이터 가져오기
		List<Exam12Member> mlist = service.memberListPage(pageNo, rowsPerPage);
		
		// View(JSP)로 넘겨줄 데이터
		model.addAttribute("mlist", mlist);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		model.addAttribute("pageNo", pageNo);
		
		
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "jdbc/exam06";
	}
	
	@RequestMapping(value = "/jdbc/exam03", method = RequestMethod.GET)
	public String exam06WriteGet() {
		return "jdbc/exam03";

	}

	@RequestMapping(value = "/jdbc/exam03", method = RequestMethod.POST)
	public String exam06WritePost(Exam12Member member) throws Exception {
		// board Command 객체
		// 첨부 파일에 대한 정보를 컬럼값으로 설정
		member.setMoriginalfilename(member.getMattach().getOriginalFilename());
		member.setMfilecontent(member.getMattach().getContentType());
		String fileName = new Date().getTime() + "-" + member.getMoriginalfilename();
		member.setMsavedfilename(fileName);
		

		// 첨부 파일을 서버 로컬 시스템에 저장
		String realPath = servletContext.getRealPath("/WEB-INF/upload/");
		LOGGER.info(realPath);
		File file = new File(realPath + fileName);
		member.getMattach().transferTo(file);

		// 서비스 객체로 요청 처리 요청
		service.memberJoin(member);

		return "redirect:/jdbc/exam06";
	}
	
	
	
	
	
	@RequestMapping("/jdbc/exam06Detail")
	public String exam06Detail(String mid, Model model){
		Exam12Member member = service.getMember(mid);
		model.addAttribute("member", member);
		
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "jdbc/exam06Detail";
	}
	
	@RequestMapping("/jdbc/exam06CheckMpassword")
	public String exam06CheckMpassword(String mid, String mpassword,Model model){
		String result = service.memberCheckMpassword(mid, mpassword);
		model.addAttribute("result", result);
		
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "jdbc/exam06CheckMpassword";
	}
	
	@RequestMapping(value="/jdbc/exam06Update", method = RequestMethod.GET)
	public String exam06UpdateGet(String mid, Model model){
		Exam12Member member = service.getMember(mid);
		model.addAttribute("member", member);
		// View 이름 리턴 -> jsp에서 페이저 만들 때 사용한다.
		return "jdbc/exam06Update";
		
	}
	
	@RequestMapping(value="/jdbc/exam06Update", method = RequestMethod.POST)
	public String exam06UpdatePost(Exam12Member member) throws Exception{ // exam05Update의 수정될 사항들 매개변수로 받아야 or 커멘드 객체로 통째로
		// 첨부파일이 변경되었는지 검사
		LOGGER.info(String.valueOf(member.getMattach().isEmpty()));
		if(!member.getMattach().isEmpty()){
			
			// 첨부 파일에 대한 정보를 컬럼값으로 설정
			member.setMoriginalfilename(member.getMattach().getOriginalFilename());
			member.setMfilecontent(member.getMattach().getContentType());
			String fileName = new Date().getTime() +"-" +member.getMoriginalfilename();
			member.setMsavedfilename(fileName);
			
			// 첨부파일을 서버 로컬 시스템에 저장
			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			File file = new File(realPath + fileName);
			member.getMattach().transferTo(file);
			
		}
		
		// 게시물 수정 처리
		service.memberUpdate(member);
		return "redirect:/jdbc/exam06Detail?mid=" + member.getMid();
	}
	
	@RequestMapping("/jdbc/exam06Delete")
	public String exam06Delete(String mid){
		service.memberDelete(mid);
		return "redirect:/jdbc/exam06";
	}
	
	
}

package com.mycompany.myapp.dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;


@Component
public class Exam12DaoImpl3 implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl3.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	

	@Override
	public int boardInsert(Exam12Board board) {
		//int bno=sqlSessionTemplate.insert("board.insert",board); 로 받으면 bno는 무조건 1이 나옴(삽입된 행의 수임)
	    sqlSessionTemplate.insert("board.insert",board);  //namespace.id , parameter
		return board.getBno();
		
	}

	@Override
	public List<Exam12Board> boardSelectAll() {
		List<Exam12Board> list = sqlSessionTemplate.selectList("board.selectAll"); //namespace.id 
		return list;
	}

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum",(pageNo-1) * rowsPerPage + 1);
		map.put("endNum",pageNo*rowsPerPage );
		List<Exam12Board> list = sqlSessionTemplate.selectList("board.selectByPage", map); //namespace.id 
			
			return list;
	}
	
	@Override
	public int boardCountAll() {
		int count=sqlSessionTemplate.selectOne("board.countAll");
		return count;
		
	}
	
	@Override
	public Exam12Board boardSelectByBno(int bno){
		
		Exam12Board board = sqlSessionTemplate.selectOne("board.selectByBno",bno);
		return board;
		
	}
	
	
	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bhitcount",bhitcount);
		map.put("bno",bno);
		sqlSessionTemplate.update("board.updateBhitcount", map);
		
	}
	
	
	@Override
	public void boardUpdate(Exam12Board board) {
	
		sqlSessionTemplate.update("board.update", board);
	}
	
	@Override
	public void boardDelete(int bno) {

		sqlSessionTemplate.delete("board.delete",bno);
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String memberInsert(Exam12Member member) {
		
		sqlSessionTemplate.insert("member.insert",member);  //namespace.id , parameter
		return member.getMid();
	}
	
	@Override
	public int memberCountAll() {
		int count=sqlSessionTemplate.selectOne("member.countAll");
		return count;
		
		
	}
	
	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum",(pageNo-1) * rowsPerPage + 1);
		map.put("endNum",pageNo*rowsPerPage );
		List<Exam12Member> list = sqlSessionTemplate.selectList("member.selectByPage", map); //namespace.id 
			
			return list;
			
	}
	

	

	
	@Override
	public Exam12Member memberSelectByMid(String mid) {
		
		Exam12Member member = sqlSessionTemplate.selectOne("member.selectByMid",mid);
		return member;
	}
	
	@Override
	public void memberUpdate(Exam12Member member) {
	
		sqlSessionTemplate.update("member.update", member);
			
	}
	
	@Override
	public void memberDelete(String mid) {
		
		sqlSessionTemplate.delete("member.delete",mid);
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////	
	/*
	public static void main(String[] args) {
		
		
		Exam12DaoImpl test = new Exam12DaoImpl();
		List<Exam12Board> list = test.boardSelectPage(2, 10);
		for(Exam12Board board:list){
			LOGGER.info(board.getBtitle());
		}
		

		Exam12DaoImpl2 test = new Exam12DaoImpl2();
		
		// 100개 데이터를 멤버에 추가
		
		for(int i=1;i<=100;i++){
			List<Exam12Member> mlist = new ArrayList<>();
			Exam12Member member = new Exam12Member();
			member.setMname("멤버" + i);
			member.setMid("id" + i);
			member.setMpassword("12345");
			member.setMdate(member.getMdate()); // 날짜 받는거
			member.setMtel("번호"+ i);
			member.setMage(i);
			member.setMaddress("주소" + i);
			member.setMoriginalfilename("a"+i+".png");
			member.setMsavedfilename("b"+i+".png");
			member.setMfilecontent("image/png");
			test.memberInsert(member);
			//mlist.add(member);
			LOGGER.info(member.getMid());
		}
		
		
		
		// 멤버의 페이지 셀렉터
		List<Exam12Member> mlist = test.memberSelectPage(2, 10);
		for(Exam12Member member:mlist){
			LOGGER.info(member.getMid());
		}
		
	}*/

	
}

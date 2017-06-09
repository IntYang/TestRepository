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
import java.util.List;

import javax.sql.DataSource;

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
public class Exam12DaoImpl2 implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl2.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	@Override
	public int boardInsert(Exam12Board board) {
		

		// SQL 작성
		final String sql = "insert into board " +
		"(bno,btitle, bcontent, bwriter, bdate, bpassword, bhitcount, boriginalfilename, bsavedfilename, bfilecontent)" +
		"values" +
	    "(board_bno_seq.nextval, ?,?,?,sysdate,?,0,?,?,?)"; // 매개변수화된 sql문

		/*
		jdbcTemplate.update(sql,board.getBtitle(), board.getBcontent(), board.getBwriter(), board.getBpassword(), 
				board.getBhitcount(), board.getBoriginalfilename(), board.getBsavedfilename(), board.getBfilecontent());;
				*/
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"bno"});
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBpassword());
			
					pstmt.setString(4, board.getBoriginalfilename());
					pstmt.setString(5, board.getBsavedfilename());
					pstmt.setString(6, board.getBfilecontent());
					pstmt.setInt(7, board.getBno());
				return pstmt;
			}
		};
				
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc, keyHolder);
		int bno = keyHolder.getKey().intValue();
		
		LOGGER.info(String.valueOf(bno));
		
		return bno;
		
	}

	@Override
	public List<Exam12Board> boardSelectAll() {
		List<Exam12Board> list = new ArrayList<>();
	
			// SQL 작성
			String sql = "select bno,btitle,bwriter,bdate,bhitcount ";
			sql += "from board ";
			sql += "order by bno desc";
			RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>(){
				@Override
				public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Exam12Board board = new Exam12Board();
					board.setBno(rs.getInt("bno"));
					board.setBtitle(rs.getString("btitle"));
					board.setBwriter(rs.getString("bwriter"));
					board.setBdate(rs.getDate("bdate"));
					board.setBhitcount(rs.getInt("bhitcount"));
					
					return board;
				}
				
			};
			
			list = jdbcTemplate.query(sql, rowMapper); // 하나의 행을 어떤 객체로 표현할 것인가
			return list;
	}

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {
		
			String sql = "select * ";
			sql += "from( ";
			sql += "  select rownum as r, bno, btitle, bwriter, bdate, bhitcount";
			sql += "  from( ";
			sql += "  select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc ";
			sql += "  ) ";
			sql += "  where rownum<=? ";
			sql += ") ";
			sql += "where r>=? ";
			
			Object[] args = {(pageNo*rowsPerPage),((pageNo-1)*rowsPerPage + 1)};
			
			RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>(){
				@Override
				public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Exam12Board board = new Exam12Board();
					board.setBno(rs.getInt("bno"));
					board.setBtitle(rs.getString("btitle"));
					board.setBwriter(rs.getString("bwriter"));
					board.setBdate(rs.getDate("bdate"));
					board.setBhitcount(rs.getInt("bhitcount"));
					
					return board;
				}
				
			};
			
	
			List<Exam12Board> list = jdbcTemplate.query(sql,args,rowMapper);
			return list;
	}
	
	@Override
	public int boardCountAll() {
		
			// SQL 작성
		String sql = "select count(*) from board ";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
		
	}
	
	@Override
	public Exam12Board boardSelectByBno(int bno){
		
		String sql = "select * from board where bno=? ";
		

		RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>(){
			@Override
			public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBpassword(rs.getString("bpassword"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));
				return board;
			}
			
		};
	
		Exam12Board board= jdbcTemplate.queryForObject(sql, rowMapper, bno);	

		return board;
		
	}
	
	
	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		// SQL 작성
		String sql = "update board set bhitcount=? where bno=? ";
	    jdbcTemplate.update(sql, bhitcount,bno);	// 엡데이트된 행의 수
		
	}
	
	
	@Override
	public void boardUpdate(Exam12Board board) {
		String sql;
		if(board.getBoriginalfilename()!=null){
			sql="update board set btitle=?,bcontent=?,bpassword=?,bdate=sysdate,boriginalfilename?,bsavedfilename=?,bfilecontent=? where bno=? ";
			jdbcTemplate.update(sql,board.getBtitle(), board.getBcontent(), board.getBpassword(),board.getBoriginalfilename(), board.getBsavedfilename(), board.getBfilecontent(), board.getBno());
		}else{
			sql="update board set btitle=?,bcontent=?,bpassword=?,bdate=sysdate where bno=? ";
			jdbcTemplate.update(sql,board.getBtitle(), board.getBcontent(), board.getBpassword(),board.getBno());
		}
	}
	
	@Override
	public void boardDelete(int bno) {

		// SQL 작성
		String sql= "delete from board where bno=? ";
		
		jdbcTemplate.update(sql,bno);
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String memberInsert(Exam12Member member) {
		
			String sql = "insert into member ";
			sql += "(mid, mname, mpassword, mdate, mtel, memail, mage, maddress, moriginalfilename, msavedfilename, mfilecontent)";
			sql += "values";
			sql += "(?, ?,?,sysdate,?,?,?,?,?,?,?)"; // 매개변수화된 sql문

			jdbcTemplate.update(
					sql, member.getMid(), member.getMname(), member.getMpassword(), member.getMtel(), member.getMemail(), member.getMage(),
					member.getMaddress(), member.getMoriginalfilename(), member.getMsavedfilename(), member.getMfilecontent());
		return member.getMid();
	}
	
	
	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {
			// SQL 작성
			String sql = "select * ";
			sql += "from( ";
			sql += "  select rownum as r, mid, mname, mtel, mdate, mage";
			sql += "  from( ";
			sql += "  select mid, mname, mtel, mdate, mage from member order by mage desc ";
			sql += "  ) ";
			sql += "  where rownum<=? ";
			sql += ") ";
			sql += "where r>=? ";
			
			Object[] args = {(pageNo*rowsPerPage),((pageNo-1)*rowsPerPage + 1)};
			
			RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>(){
				@Override
				public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Exam12Member member = new Exam12Member();
					member.setMid(rs.getString("mid"));
					member.setMname(rs.getString("mname"));
					member.setMtel(rs.getString("mtel"));
					member.setMdate(rs.getDate("mdate"));
					member.setMage(rs.getInt("mage"));
					
					return member;
				}
				
			};
			List<Exam12Member> list = jdbcTemplate.query(sql,args,rowMapper);
			return list;
	}
	

	@Override
	public int memberCountAll() {
		// SQL 작성
		//String sql = "select count(*) from board ";
		//int count = jdbcTemplate.queryForObject(sql, Integer.class);
		//return count;
		String sql = "select count(*) from member ";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return count;
		
	}

	
	@Override
	public Exam12Member memberSelectByMid(String mid) {
		
		// SQL 작성
		String sql = "select * from member where mid=? ";
		RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>(){
			public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Member member = new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMdate(rs.getDate("mdate"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				member.setMage(rs.getInt("mage"));
				member.setMaddress(rs.getString("maddress"));
				member.setMoriginalfilename(rs.getString("moriginalfilename"));
				member.setMsavedfilename(rs.getString("msavedfilename"));
				member.setMfilecontent(rs.getString("mfilecontent"));
				
				return member;
				
				
			}
		};	
		
		Exam12Member member = jdbcTemplate.queryForObject(sql, rowMapper, mid);
		return member;
	}
	
	@Override
	public void memberUpdate(Exam12Member member) {
	
			String sql;
			
			if(member.getMoriginalfilename() != null){
				sql= "update member set mname=?,mpassword=?,mdate=sysdate,mtel=?,memail=?,mage=?,maddress=?,moriginalfilename=?,msavedfilename=?,mfilecontent=? where mid=? ";
				jdbcTemplate.update(sql, member.getMname(), member.getMpassword(), member.getMtel(),member.getMemail(), 
						member.getMage(), member.getMaddress(),member.getMoriginalfilename(), member.getMsavedfilename(), 
						member.getMfilecontent(), member.getMid());
			}else{
				sql= "update member set mname=?,mpassword=?,mdate=sysdate,mtel=?,memail=?,mage=?,maddress=? where mid=? ";
				jdbcTemplate.update(sql, member.getMname(), member.getMpassword(),member.getMtel(),member.getMemail(), 
						member.getMage(), member.getMaddress(), member.getMid());
				}
			
			
	}
	
	@Override
	public void memberDelete(String mid) {
		
			String sql= "delete from member where mid=? ";
			jdbcTemplate.update(sql,mid);
			
		
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

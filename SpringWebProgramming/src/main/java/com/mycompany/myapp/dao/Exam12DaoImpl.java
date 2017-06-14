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
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl.class);
	
	@Autowired
	
	private DataSource dataSource;
	@Override
	public int boardInsert(Exam12Board board) {
		int bno = -1;
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			//Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			//String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			//conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			conn = dataSource.getConnection();
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "insert into board ";
			sql += "(bno, btitle, bcontent, bwriter, bdate, bpassword, bhitcount, boriginalfilename, bsavedfilename, bfilecontent) ";
			sql += "values ";
			sql += "(board_bno_seq.nextval, ?, ?, ?, sysdate, ?, 0, ?, ?, ?) ";
			//SQL 문을 전송해서 실행
			//테이블 정의시 컬럼의 속성으로 자동 증가를 지정할 수 있는 DB일 경우(MySQL, MS SQL)
			//PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//오라클일 경우 Sequence 외부 객체로 자동 증가값을 얻기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setString(4, board.getBpassword());
			pstmt.setString(5, board.getBoriginalfilename());
			pstmt.setString(6, board.getBsavedfilename());
			pstmt.setString(7, board.getBfilecontent());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			bno = rs.getInt(1);
			pstmt.close();
			LOGGER.info("행 추가 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//연결 끊기
			try { 
				conn.close(); 
				LOGGER.info("연결 끊김");
			} catch (SQLException e) { }
		}
		return bno;
	}

	@Override
	public List<Exam12Board> boardSelectAll() {
		List<Exam12Board> list = new ArrayList<>();
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select bno, btitle, bwriter, bdate, bhitcount ";
			sql += "from board ";
			sql += "order by bno desc ";
			//SQL 문을 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString(3));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				list.add(board);
			}
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//연결 끊기
			try { 
				conn.close(); 
				LOGGER.info("연결 끊김");
			} catch (SQLException e) { }
		}		
		return list;
	}
	
	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {
		List<Exam12Board> list = new ArrayList<>();
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select * ";
			sql += "from ( ";
			sql += "  select rownum as r, bno, btitle, bwriter, bdate, bhitcount ";
			sql += "  from ( ";
			sql += "    select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc ";
			sql += "  ) ";
			sql += "  where rownum<=? ";
			sql += ") ";
			sql += "where r>=? ";
			//SQL 문을 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo*rowsPerPage);
			pstmt.setInt(2, (pageNo-1) * rowsPerPage + 1);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString(4));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				list.add(board);
			}
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//연결 끊기
			try { 
				conn.close(); 
				LOGGER.info("연결 끊김");
			} catch (SQLException e) { }
		}		
		return list;
	}	
	
	@Override
	public int boardCountAll() {
		int count = 0;
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select count(*) from board";
			//SQL 문을 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//연결 끊기
			try { 
				conn.close(); 
				LOGGER.info("연결 끊김");
			} catch (SQLException e) { }
		}		
		return count;
	}
	
	@Override
	public Exam12Board boardSelectByBno(int bno) {
		Exam12Board board = null;
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "select * from board where bno=?";
			//SQL 문을 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBpassword(rs.getString("bpassword"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));
			}
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//연결 끊기
			try { 
				conn.close(); 
				LOGGER.info("연결 끊김");
			} catch (SQLException e) { }
		}		
		return board;
	}
	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공");
			//매개 변수화된 SQL 작성
			String sql = "update board set bhitcount=? where bno=?";
			//SQL 문을 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bhitcount);
			pstmt.setInt(2, bno);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//연결 끊기
			try { 
				conn.close(); 
				LOGGER.info("연결 끊김");
			} catch (SQLException e) { }
		}
	}
	
	@Override
	public void boardUpdate(Exam12Board board) {
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			//매개 변수화된 SQL 작성
			String sql;
			if(board.getBoriginalfilename() != null) {
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate, boriginalfilename=?, bsavedfilename=?, bfilecontent=?  where bno=?";
			} else {
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate  where bno=?";
			}
			//SQL 문을 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBpassword());
			if(board.getBoriginalfilename() != null) {
				pstmt.setString(4, board.getBoriginalfilename());
				pstmt.setString(5, board.getBsavedfilename());
				pstmt.setString(6, board.getBfilecontent());
				pstmt.setInt(7, board.getBno());
			} else {
				pstmt.setInt(4, board.getBno());
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//연결 끊기
			try { 
				conn.close(); 
				LOGGER.info("연결 끊김");
			} catch (SQLException e) { }
		}
	}	
	
	@Override
	public void boardDelete(int bno) {
		Connection conn = null;
		try {
			//JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			//매개 변수화된 SQL 작성
			String sql = "delete from board where bno=?";
			//SQL 문을 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//연결 끊기
			try { 
				conn.close(); 
				LOGGER.info("연결 끊김");
			} catch (SQLException e) { }
		}
	}
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String memberInsert(Exam12Member member) {
		String mid = "아이디";
		Connection conn2 = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn2 = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");

			// SQL 작성
			String sql2 = "insert into member ";
			sql2 += "(mid, mname, mpassword, mdate, mtel, memail, mage, maddress, moriginalfilename, msavedfilename, mfilecontent)";
			sql2 += "values";
			sql2 += "(?, ?,?,sysdate,?,?,?,?,?,?,?)"; // 매개변수화된 sql문

			// SQL문을 전송해서 실행
			//Statement stmt = conn.createStatement();
			//stmt.executeUpdate(sql);
			//stmt.close();
			// 테이블 정의 시 컬럼의 속성으로 자동 증가를 지정할 수 있는 DB일 경우(MySQL, MS SQL)
//			PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//오라클일 경우 Sequence 외부 객체로 자동 증가값을 얻기 때문에 다음과 같이 지정
			PreparedStatement pstmt2 = conn2.prepareStatement(sql2);
			pstmt2.setString(1, member.getMid());
			pstmt2.setString(2, member.getMname());
			pstmt2.setString(3, member.getMpassword());
			pstmt2.setString(4, member.getMtel());
			pstmt2.setString(5, member.getMemail());
			pstmt2.setInt(6, member.getMage());
			pstmt2.setString(7, member.getMaddress());
			pstmt2.setString(8, member.getMoriginalfilename());
			pstmt2.setString(9, member.getMsavedfilename());
			pstmt2.setString(10, member.getMfilecontent());
			
			pstmt2.executeUpdate(); // sql 문을 실행하라
			mid = member.getMid();
			pstmt2.close();
			LOGGER.info("멤버 행 추가 성공");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn2.close();
				LOGGER.info("멤버 연결 끊김");
			} catch (SQLException e) {}
		}
		return mid;
	}
	
	
	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {
		List<Exam12Member> mlist = new ArrayList<>();
		
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url1 = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url1, "iotuser", "iot12345");
			LOGGER.info("연결성공");

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
			
					

			// SQL문을 전송하여 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo*rowsPerPage);
			pstmt.setInt(2, (pageNo-1)*rowsPerPage + 1);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Exam12Member member = new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMtel(rs.getString("mtel"));
				member.setMdate(rs.getDate("mdate"));
				member.setMage(rs.getInt("mage"));
				mlist.add(member);
			}
			rs.close();
			pstmt.close();
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}
		}
		
		
		return mlist;
	}
	

	@Override
	public int memberCountAll() {
		int count = 0;
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url1 = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url1, "iotuser", "iot12345");
			LOGGER.info("연결성공");

			// SQL 작성
			String sql = "select count(*) from member ";
			
					

			// SQL문을 전송하여 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
			rs.close();
			pstmt.close();
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}
		}
		
		
		return count;
		
	}

	
	@Override
	public Exam12Member memberSelectByMid(String mid) {
		Exam12Member member = null;
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url1 = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url1, "iotuser", "iot12345");
			LOGGER.info("연결성공");

			// SQL 작성
			String sql = "select * from member where mid=? ";
			

			// SQL문을 전송하여 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				member = new Exam12Member();
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
				
			}
			rs.close();
			pstmt.close();
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}
		}
		
		
		return member;
	}
	
	@Override
	public void memberUpdate(Exam12Member member) {
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url1 = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url1, "iotuser", "iot12345");
			LOGGER.info("연결성공");

			// SQL 작성
			String sql;
			
			if(member.getMoriginalfilename() != null){
				sql= "update member set mname=?,mpassword=?,mdate=sysdate,mtel=?,memail=?,mage=?,maddress=?,moriginalfilename=?,msavedfilename=?,mfilecontent=? where mid=? ";
					
			}else{
				sql= "update member set mname=?,mpassword=?,mdate=sysdate,mtel=?,memail=?,mage=?,maddress=? where mid=? ";
				}
			
			
					

			// SQL문을 전송하여 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMname());
			pstmt.setString(2, member.getMpassword());
			pstmt.setString(3, member.getMtel());
			pstmt.setString(4, member.getMemail());
			pstmt.setInt(5, member.getMage());
			pstmt.setString(6, member.getMaddress());
			if(member.getMoriginalfilename()!=null)
			{
				pstmt.setString(7, member.getMoriginalfilename());
				pstmt.setString(8, member.getMsavedfilename());
				pstmt.setString(9, member.getMfilecontent());
				pstmt.setString(10, member.getMid());
			}else{
				pstmt.setString(7, member.getMid());
			}
			
			pstmt.executeUpdate();
			
			pstmt.close();
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}
		}
		
	}
	
	@Override
	public void memberDelete(String mid) {
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url1 = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url1, "iotuser", "iot12345");
			LOGGER.info("연결성공");

			// SQL 작성
			String sql= "delete from member where mid=? ";
			
			
					

			// SQL문을 전송하여 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
			pstmt.close();
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////	
	
/*
	public static void main(String[] args) {
		
		
		Exam12DaoImpl test = new Exam12DaoImpl();
		List<Exam12Board> list = test.boardSelectPage(2, 10);
		for(Exam12Board board:list){
			LOGGER.info(board.getBtitle());
		}
		

		
		
		Exam12DaoImpl test = new Exam12DaoImpl();
		
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
		

		
	}
*/
	
}

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl.class);

	@Override
	public int boardInsert(Exam12Board board) {
		int bno = -1;
		Connection conn1 = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url1 = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn1 = DriverManager.getConnection(url1, "iotuser", "iot12345");
			LOGGER.info("연결성공");

			// SQL 작성
			String sql1 = "insert into board ";
			sql1 += "(bno,btitle, bcontent, bwriter, bdate, bpassword, bhitcount, boriginalfilename, bsavedfilename, bfilecontent)";
			sql1 += "values";
			sql1 += "(board_bno_seq.nextval, ?,?,?,sysdate,?,0,?,?,?)"; // 매개변수화된 sql문

			// SQL문을 전송해서 실행
			//Statement stmt = conn.createStatement();
			//stmt.executeUpdate(sql);
			//stmt.close();
			// 테이블 정의 시 컬럼의 속성으로 자동 증가를 지정할 수 있는 DB일 경우(MySQL, MS SQL)
//			PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//오라클일 경우 Sequence 외부 객체로 자동 증가값을 얻기 때문에 다음과 같이 지정
			PreparedStatement pstmt1 = conn1.prepareStatement(sql1,new String[]{"bno"});
			pstmt1.setString(1, board.getBtitle());
			pstmt1.setString(2, board.getBcontent());
			pstmt1.setString(3, board.getBwriter());
			pstmt1.setString(4, board.getBpassword());
			pstmt1.setString(5, board.getBoriginalfilename());
			pstmt1.setString(6, board.getBsavedfilename());
			pstmt1.setString(7, board.getBfilecontent());
			
			pstmt1.executeUpdate(); // sql 문을 실행하라
			ResultSet rs1 = pstmt1.getGeneratedKeys();
			rs1.next();
			 bno = rs1.getInt(1); // 첫번째 컬럼의 정수값
			pstmt1.close();
			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결끊기
			try {
				conn1.close();
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {}
		}
		return bno;
		
	}

	@Override
	public List<Exam12Board> boardSelectAll() {
		List<Exam12Board> list = new ArrayList<>();
		
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url1 = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url1, "iotuser", "iot12345");
			LOGGER.info("연결성공");

			// SQL 작성
			String sql = "select bno,btitle,bwriter,bdate,bhitcount ";
			sql += "from board ";
			sql += "order by bno desc";
					

			// SQL문을 전송하여 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				list.add(board);
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
		
		
		return list;
	}

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {
		List<Exam12Board> list = new ArrayList<>();
		
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
			sql += "  select rownum as r, bno, btitle, bwriter, bdate, bhitcount";
			sql += "  from( ";
			sql += "  select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc ";
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
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				list.add(board);
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
		
		
		return list;
	}
	
	@Override
	public int boardCountAll() {
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
			String sql = "select count(*) from board ";
			
					

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


	
///////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static void main(String[] args) {
		
		/*
		Exam12DaoImpl test = new Exam12DaoImpl();
		List<Exam12Board> list = test.boardSelectPage(2, 10);
		for(Exam12Board board:list){
			LOGGER.info(board.getBtitle());
		}
		*/

		
		
		Exam12DaoImpl test = new Exam12DaoImpl();
		
		// 100개 데이터를 멤버에 추가
		/*
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
		
		*/
		
		// 멤버의 페이지 셀렉터
		List<Exam12Member> mlist = test.memberSelectPage(2, 10);
		for(Exam12Member member:mlist){
			LOGGER.info(member.getMid());
		}
		

		
	}

	
}

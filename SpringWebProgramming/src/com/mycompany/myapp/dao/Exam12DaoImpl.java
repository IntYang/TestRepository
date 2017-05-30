package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl.class);

	@Override
	public int insert1(Exam12Board board) {
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
	public String insert2(Exam12Member member) {
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

	public static void main(String[] args) {
		/*Exam12DaoImpl test = new Exam12DaoImpl();
		Exam12Board board = new Exam12Board();
		board.setBtitle("제목");
		board.setBcontent("내용");
		board.setBwriter("헝그리");
		board.setBpassword("12345");
		board.setBoriginalfilename("a.png");
		board.setBsavedfilename("a.png");
		board.setBfilecontent("image/png");
	//	test.insert1(board);
		
		int bno = test.insert1(board);
		LOGGER.info("추가된 행의 bno: " + bno);*/
		
		
		Exam12DaoImpl test2 = new Exam12DaoImpl();
		Exam12Member member = new Exam12Member();
		
	
		
		member.setMname("donggle");
		member.setMname("스프링 공부요");
		member.setMpassword("12345");
		member.setMtel("01053332105");
		member.setMemail("huntsu@naver.com");
		member.setMaddress("서울 동작");
		member.setMoriginalfilename("b.png");
		member.setMsavedfilename("b.png");
		member.setMfilecontent("image/png");
	//	test.insert1(board);
		

		
		String mid = test2.insert2(member);
		LOGGER.info("추가된 행의 mid: " + mid);
		
	}



	

}

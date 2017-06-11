package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Gallery;

@Component
public class GalleryDaoImpl implements GalleryDao{

	@Override
	public int galleryInsert(Gallery gallery) {
		int gno = -1;
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			conn = DriverManager.getConnection(url, "user01", "java12345");
			//LOGGER.info("연결성공");

			// SQL 작성
			String sql = "insert into gallery ";
			sql += "(gno,title,originalfilename,savedfilename,filecontent,filepath) ";
			//sql += "(gno,title,originalfilename,savedfilename,filecontent) ";
			sql += "values ";
			sql += "(gallery_gno_seq.nextval,?,?,?,?,?)"; // 매개변수화된 sql문
			//sql += "(gallery_gno_seq.nextval,?,?,?,?)"; 
			// SQL문을 전송해서 실행
			//Statement stmt = conn.createStatement();
			//stmt.executeUpdate(sql);
			//stmt.close();
			// 테이블 정의 시 컬럼의 속성으로 자동 증가를 지정할 수 있는 DB일 경우(MySQL, MS SQL)
//			PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//오라클일 경우 Sequence 외부 객체로 자동 증가값을 얻기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql,new String[]{"gno"});
			pstmt.setString(1, gallery.getTitle());
			
			pstmt.setString(2, gallery.getOriginalfilename());
			pstmt.setString(3, gallery.getSavedfilename());
			pstmt.setString(4, gallery.getFilecontent());
			pstmt.setString(5, gallery.getFilepath());
			
			pstmt.executeUpdate(); // sql 문을 실행하라
			
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			 gno = rs.getInt(1); // 첫번째 컬럼의 정수값
			pstmt.close();
			//LOGGER.info("행 추가 성공");

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
			} catch (SQLException e) {}
		}
		return gno;
	}

	@Override
	public List<Gallery> gallerySelectAll() {
		List<Gallery> list = new ArrayList<>();
		
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			conn = DriverManager.getConnection(url, "user01", "java12345");

			// SQL 작성
			String sql = "select gno,title ";
			sql += "from gallery ";
			sql += "order by gno desc";
					

			// SQL문을 전송하여 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Gallery gallery = new Gallery();
				gallery.setGno(rs.getInt("gno"));
				gallery.setTitle(rs.getString("title"));
				
				list.add(gallery);
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
			} catch (SQLException e) {}
		}
		
		return list;
	}

	@Override
	public Gallery gallerySelectByGno(int gno) {
		Gallery gallery = null;
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			conn = DriverManager.getConnection(url, "user01", "java12345");
			
			String sql = "select * from gallery where gno=? ";
			// SQL문을 전송하여 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				gallery =new Gallery();
				gallery.setGno(rs.getInt("gno"));
				gallery.setTitle(rs.getString("title"));
				
				gallery.setOriginalfilename(rs.getString("originalfilename"));
				gallery.setSavedfilename(rs.getString("savedfilename"));
				gallery.setFilecontent(rs.getString("filecontent"));
				gallery.setFilepath(rs.getString("filepath"));
				
				
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
			} catch (SQLException e) {}
		}
		
		
		return gallery;
	}

	@Override
	public void galleryUpdate(Gallery gallery) {
		
	
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			conn = DriverManager.getConnection(url, "user01", "java12345");

			// SQL 작성
			String sql;
			
			if(gallery.getOriginalfilename()!= null){
				sql= "update gallery set title=?,originalfilename=?,savedfilename=?,filecontent=?,filepath=? where gno=? ";
					
			}else{
				sql= "update gallery set title=? where gno=? ";
				}
			
			
					

			// SQL문을 전송하여 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gallery.getTitle());
			
			if(gallery.getOriginalfilename()!=null)
			{
				pstmt.setString(2, gallery.getOriginalfilename());
				pstmt.setString(3, gallery.getSavedfilename());
				pstmt.setString(4, gallery.getFilecontent());
				pstmt.setString(5, gallery.getFilepath());
				pstmt.setInt(6, gallery.getGno());
				
			}else{
				pstmt.setInt(2, gallery.getGno());
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
				
			} catch (SQLException e) {}
		}
		
	}
	
	
	/*
	public static void main(String[] args) {
		
		GalleryDaoImpl test = new GalleryDaoImpl();
		
		for(int i=1;i<=30;i++){
			List<Gallery> list = new ArrayList<>();
			Gallery gallery = new Gallery();
			gallery.setGno(i);
			gallery.setTitle("제목" + i);
			
			gallery.setOriginalfilename("iot"+i+".jpg");
			gallery.setSavedfilename("iot"+i+".jpg");
			gallery.setFilecontent("image/jpg");
			gallery.setFilepath("/WEB-INF/upload/iot" + i +".jpg");
			test.galleryInsert(gallery);
			//mlist.add(member);
		}
	
	}
*/
	@Override
	public List<Gallery> gallerySelectPage(int pageNo, int rowsPerPage) {
		List<Gallery> list = new ArrayList<>();
		
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			conn = DriverManager.getConnection(url, "user01", "java12345");

			// SQL 작성
			String sql = "select * ";
			sql += "from( ";
			sql += "  select rownum as r, gno, title";
			sql += "  from( ";
			sql += "  select gno, title from gallery order by gno desc";
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
				Gallery gallery = new Gallery();
				gallery.setGno(rs.getInt("gno"));
				gallery.setTitle(rs.getString("title"));
				
				list.add(gallery);
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
				//LOGGER.info("연결 끊김");
			} catch (SQLException e) {}
		}
		
		
		return list;
		
	}

	@Override
	public int galleryCountAll() {
		int count = 0;
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			conn = DriverManager.getConnection(url, "user01", "java12345");

			// SQL 작성
			String sql = "select count(*) from gallery ";
			
					

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
			//	LOGGER.info("연결 끊김");
			} catch (SQLException e) {}
		}
		
		
		return count;
	}
	
	@Override
	public void galleryDelete(int gno) {
		Connection conn = null;

		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			conn = DriverManager.getConnection(url, "user01", "java12345");

			// SQL 작성
			String sql= "delete from gallery where gno=? ";
			
			
					

			// SQL문을 전송하여 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
	
			pstmt.setInt(1, gno);
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
			} catch (SQLException e) {}
		}
	}
	

}

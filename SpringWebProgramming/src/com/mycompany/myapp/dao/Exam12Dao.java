package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

public interface Exam12Dao {
	public int boardInsert(Exam12Board board);
	public List<Exam12Board> boardSelectAll(); // select는 여러 행이 리턴되기 때문에, 보통 리턴 타입이 리스트임
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage);
	public int boardCountAll();
	public Exam12Board boardSelectByBno(int bno);
	public void boardUpdateBhitcount(int bno, int bhitcount);
	public void boardUpdate(Exam12Board board);
	public void boardDelete(int bno);
	
	public String memberInsert(Exam12Member member);
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage);
	public int memberCountAll();
	public Exam12Member memberSelectByMid(String mid);
	public void memberUpdate(Exam12Member member);
	public void memberDelete(String mid);
}

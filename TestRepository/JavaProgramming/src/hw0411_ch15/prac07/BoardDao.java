package hw0411_ch15.prac07;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	public List<Board> getBoardList(){
		List<Board> bList = new ArrayList<>();
		bList.add(new Board("����1", "����1"));
		bList.add(new Board("����2", "����2"));
		bList.add(new Board("����3", "����3"));
		
		return bList;
	}
}

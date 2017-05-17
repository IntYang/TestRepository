package hw0411_ch15.prac07;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	public List<Board> getBoardList(){
		List<Board> bList = new ArrayList<>();
		bList.add(new Board("力格1", "郴侩1"));
		bList.add(new Board("力格2", "郴侩2"));
		bList.add(new Board("力格3", "郴侩3"));
		
		return bList;
	}
}

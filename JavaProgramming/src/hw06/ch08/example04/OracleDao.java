package hw06.ch08.example04;

public class OracleDao implements DataAccessObject {
	@Override
	public void select() {
		System.out.println("Oracle에서 검색");
	}
	@Override
	public void insert() {
		System.out.println("Oracle에서 삽입");
	}
	@Override
	public void update() {
		System.out.println("Oracle에서 수정");
	}
	
	@Override
	public void delete() {
		System.out.println("Oracle에서 삭제");
	}
	
}

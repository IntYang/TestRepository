package hw06.ch08.example04;

public class MySqlDao implements DataAccessObject{
	@Override
	public void select() {
		System.out.println("Mysql���� �˻�");
	}
	@Override
	public void insert() {
		System.out.println("Mysql���� ����");
	}
	@Override
	public void update() {
		System.out.println("Mysql���� ����");
	}
	
	@Override
	public void delete() {
		System.out.println("Mysql���� ����");
	}
	
}

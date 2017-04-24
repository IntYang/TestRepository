package hw06.ch08.example04;

public class DaoExample {
	public static void dbWork(DataAccessObject dao){
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
	
	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}
}

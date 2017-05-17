package hw06.ch08.example05;

public class ActionExample {
	public static void main(String[] args) {
		Action action = new Action(){
			@Override
			public void work() {
				// TODO Auto-generated method stub
			System.out.println("복사를 합니다");	
			}
		};
		action.work();
	}
}

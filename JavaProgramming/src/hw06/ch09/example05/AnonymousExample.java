package hw06.ch09.example05;

public class AnonymousExample {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method1();
		//�ν��Ͻ�.�żҵ�(new ��ü(){ ///�������̵� �� �޼ҵ�� } );
		anony.method2(new Vehicle(){
			@Override
			public void run() {
				System.out.println("Ʈ���� �޸��ϴ�.");
			}
		});
	}

}

package hw06.ch09.anonymousObject;

public class AnonymousExample {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		//�͸� ��ü �ʵ� ���
		anony.field.wake();
		//�͸� ��ü ���� ���� ���
		anony.method1();
		//�͸� ��ü �Ű��� ���
		//��ü.�޼ҵ�(new ��ü() { �޼ҵ��...});
		anony.method2(new Person(){
			void study(){
				System.out.println("�����մϴ�.");
			}
			void wake(){
				System.out.println("8�ÿ� �Ͼ�ϴ�.");
				study();
			}
		});
		
	}

}

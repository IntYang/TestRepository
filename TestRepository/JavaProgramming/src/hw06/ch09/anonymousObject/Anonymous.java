package hw06.ch09.anonymousObject;

public class Anonymous {
	// �ʵ� �ʱⰪ���� ����
	// Person field = new Person(){ };
	Person field = new Person() {
		void work() {
			System.out.println("����մϴ�.");
		}

		@Override
		void wake() {
			System.out.println("6�ÿ� ���");
		}
	};

	void method1() {
		// ���� ������ ����
		Person localVar = new Person() {
			void walk() {
				System.out.println("��å�մϴ�.");
			}

			@Override
			void wake() {
				System.out.println("6�ÿ� ���");
			}
		};
		// ���� ���� ���
		localVar.wake();
	}
	void method2(Person person){
		person.wake();
	}
}
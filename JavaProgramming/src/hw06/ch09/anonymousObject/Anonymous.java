package hw06.ch09.anonymousObject;

public class Anonymous {
	// 필드 초기값으로 대입
	// Person field = new Person(){ };
	Person field = new Person() {
		void work() {
			System.out.println("출근합니다.");
		}

		@Override
		void wake() {
			System.out.println("6시에 기상");
		}
	};

	void method1() {
		// 로컬 변수값 대입
		Person localVar = new Person() {
			void walk() {
				System.out.println("산책합니다.");
			}

			@Override
			void wake() {
				System.out.println("6시에 기상");
			}
		};
		// 로컬 변수 사용
		localVar.wake();
	}
	void method2(Person person){
		person.wake();
	}
}
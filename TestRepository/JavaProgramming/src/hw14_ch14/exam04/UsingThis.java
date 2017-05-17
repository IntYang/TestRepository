package hw14_ch14.exam04;

public class UsingThis {
	public int outterField = 10; // 필드 인스턴스 변수
	
	class Inner{
		int innerField = 20; // 로컬변수 final
	
		
		public Inner(){
			outterField = 100;
		}
		
		
		
		void method(){
			//람다식
//			public int outterField = 1000; // 불가능
			int innerField = 30;
			MyFunctionalInterface fi = () -> { System.out.println("outterField : " + outterField);
			 								  System.out.println("outterField : " + UsingThis.this.outterField + "\n");
											  System.out.println("innerField : " + innerField); // 로컬변수
											  System.out.println("innerField : " + this.innerField + "\n");
												// this : 로컬 클래스 내부의 필드, 로컬변수 참조
			};
			
			fi.method();
		}
	}
}

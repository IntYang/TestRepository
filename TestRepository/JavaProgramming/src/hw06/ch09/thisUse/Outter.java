package hw06.ch09.thisUse;

public class Outter {
	String field = "Outter-field";
	
	void method(){
		System.out.println("Outter-field");
	}
	
	class Nested{
		String field = "Nested - field";
		
		void method(){
			System.out.println("Nested - field");
		}
		void print(){
			System.out.println(this.field);
			this.method();  // Nested °´Ã¼ ÂüÁ¶
			System.out.println(Outter.this.field);
			Outter.this.method(); // Outter °´Ã¼ ÂüÁ¶
		}
		
	}
	
	
}

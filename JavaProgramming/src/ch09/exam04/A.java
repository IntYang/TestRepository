package ch09.exam04;
//2017. 04. 03 수업 내용
public class A {
	//field
	int field; //1번
	//Constructor
	//method
	//중첩멤버클래스
	
	class B{
		//field
		int field; //2번
		//Constructor
		//method
		void method(){
			field = 10; // == this.field = 10; -> 2번
			A.this.field = 10; // 1번 , A객체 필드의 변수 , 안드로이드에서 가끔씩나옴
		}
	} 
	
	
}

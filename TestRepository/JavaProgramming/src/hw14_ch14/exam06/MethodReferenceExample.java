package hw14_ch14.exam06;

import java.util.function.IntBinaryOperator;

public class MethodReferenceExample {
	public static void main(String[] args) {
		IntBinaryOperator operator;
		
		//정적 메소드 참조
		operator = (x,y) -> Calculator.staticMethod(x,y);
		System.out.println("결과1: "+operator.applyAsInt(3,4));
		
		operator = Calculator :: staticMethod;
		System.out.println("결과2: "+operator.applyAsInt(3,4));
		
		
		//인스턴스 메소드 참조
		
		Calculator obj = new Calculator(); //인스턴스 메소드 호출 시 객체생성 해줘야함
		operator = (x,y)->obj.instanceMethod(x, y);
		System.out.println("결과3: " + operator.applyAsInt(5, 6));
		
		operator = obj:: instanceMethod; // (x,y) 상쇄
		System.out.println("결과4: " + operator.applyAsInt(7, 8));
	}
}

package ch14.exam09;
//2017.04.11 수업 내용

import java.util.function.IntBinaryOperator;

public class LambdaExpressionExample {
	
	private static int[] scores = {92, 95, 87};
	
	
	public static void main(String[] args) {
		int max = maxOrMin((a, b)->{
			if(a>=b) return a;
			else return b;}
			);
		System.out.println("max: " + max);
		
		int min = maxOrMin((a, b)->{
			if(a<=b) return a;
			else return b;}
			);
		System.out.println("min: " + min);
		
		
		int max1 = maxOrMin((a, b)->{
			return Math.max(a, b);}
			);
		System.out.println("max1: " + max1);
		
	}
	
	public static int maxOrMin(IntBinaryOperator operator){
		int result = scores[0];
		for(int score: scores){
			result = operator.applyAsInt(result, score);
			// (92, 92)
			// (92, 95)
			// (95, 87)
		
		
		}
		return result;
	}
	
	
}

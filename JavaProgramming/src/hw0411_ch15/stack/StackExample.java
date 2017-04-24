package hw0411_ch15.stack;

import java.util.Stack;
// 스택: 후입선출
public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
	
		while(!coinBox.isEmpty()){
			Coin coin = coinBox.pop();
			System.out.println("꺼낸 동전: " + coin.getValue() + "원");
		}
	
	}
}

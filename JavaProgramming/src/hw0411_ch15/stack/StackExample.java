package hw0411_ch15.stack;

import java.util.Stack;
// ����: ���Լ���
public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
	
		while(!coinBox.isEmpty()){
			Coin coin = coinBox.pop();
			System.out.println("���� ����: " + coin.getValue() + "��");
		}
	
	}
}

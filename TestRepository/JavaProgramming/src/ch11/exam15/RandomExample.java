package ch11.exam15;
//2017.04.05 ���� ����
//�����߻���
import java.util.Random;

public class RandomExample {
	public static void main(String[] args) {
	//	Math.random(); 0 <= random < 1
		//���1
		int maxNum = 6;
		double random = Math.random();
	
		int num = (int)(random * maxNum)+1;
		System.out.println(num);
		
		//���2
		Random obj = new Random();
		int num2 = obj.nextInt(maxNum) + 1;
		System.out.println(num2);
	}
}
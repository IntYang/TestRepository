package hw14_ch14.exam03;

public class MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		
		//���ٽ� ���� ����
		fi = (x, y) -> { int result = x + y; return result;};
		System.out.println(fi.method(2,5));
		
		
		fi = (x, y) -> { return x+y;};
		System.out.println(fi.method(2,5));
		
		fi = (x, y) -> x+y;// return���� ���� ��� �߰�ȣ {} �� return ���� ����
		System.out.println(fi.method(2,5));
		
		fi = (x, y) -> sum(x,y);// ���๮�� �� ���� ������ �߰�ȣ {} ���� ����
		System.out.println(fi.method(2,5));
	}
	
	
	public static int sum(int x , int y){
		return x+y;
	}
}

package ch11.exam14;
// 2017.04.05 ���� ���� 
public class WrapperEqualsExample {
	public static void main(String[] args) {
		/*Integer v1 = new Integer(10);
		Integer v2 = new Integer(10);
		*/
		/*Integer v1 = 10;
		Integer v2 = 10;*/
		
		Integer v1 = 1000;
		Integer v2 = 1000;
		
		System.out.println(v1 == v2); //false
		//�⺻Ÿ���� �ƴ� ��� �� �񱳽� == ���� ���� ����, equals()�� ��!!
		
		System.out.println(v1.intValue() == v2.intValue());
		//���� �� �Ⱦ��� ���
		
		System.out.println(v1.equals(v2));
		
		
		
	}
}
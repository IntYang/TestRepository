package ch11.exam06;
//2017.04.04 ���� ����

public class TimeExample { //�ð� ��������
	public static void main(String[] args) {
		
		int sum=0;
//		long startTime = System.currentTimeMillis(); // ���� �ð��� long���� �����ϴ� �޼ҵ�
		long startTime = System.nanoTime(); 
		//�ð��ε� long�� ������ ���� : Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object.
		//1970�⿡ ǥ�ؽ� ����
		
		for(int i=0;i<10000000;i++){
			sum+=i;
		}
//		long endTime = System.currentTimeMillis();
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime); //1/10^9
	}
}
// OS���� ���� �� �ִ� ������
// ���� login�� �����, OS�� ����, ���� �ڹ��� ����, ȯ�溯�� ��
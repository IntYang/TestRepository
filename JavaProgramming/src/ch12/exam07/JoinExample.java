package ch12.exam07;
//2017.04.07 ���� �ð�
public class JoinExample {
	public static void main(String[] args) {
		SumThread thread =  new SumThread();
		thread.start();
		
		try{
			thread.join(); // ���ν����尡 join()��û, �Ͻ�����  // run()�޼ҵ� ������ �� ������ ���·� ��
		}catch(InterruptedException e){}
		long result = thread.getSum();
		System.out.println(result); // ���ν����尡 �� ���ϱ⵵ ���� ȣ���ؼ� 0����
		
	}
}

package hw14_ch14.exam04;

public class UsingThis {
	public int outterField = 10; // �ʵ� �ν��Ͻ� ����
	
	class Inner{
		int innerField = 20; // ���ú��� final
	
		
		public Inner(){
			outterField = 100;
		}
		
		
		
		void method(){
			//���ٽ�
//			public int outterField = 1000; // �Ұ���
			int innerField = 30;
			MyFunctionalInterface fi = () -> { System.out.println("outterField : " + outterField);
			 								  System.out.println("outterField : " + UsingThis.this.outterField + "\n");
											  System.out.println("innerField : " + innerField); // ���ú���
											  System.out.println("innerField : " + this.innerField + "\n");
												// this : ���� Ŭ���� ������ �ʵ�, ���ú��� ����
			};
			
			fi.method();
		}
	}
}

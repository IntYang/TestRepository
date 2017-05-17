package ch11.exam04;
// 2017.04.04 ���� ����
// http://docs.oracle.com/javase/8/docs/api/index.html ��ť��Ʈ ����
public class SystemExample {
	
	public static void main(String[] args) {
		
		System.setSecurityManager(new SecurityManager(){
			//������
			@Override
			public void checkExit(int status) {  //throws ��� �Ǵ� ����: ���࿹�ܶ�
				if(status!=54321) // ���� �߻����� ���� ���� �ƴ� �� ��µǰ�
					throw new SecurityException(); // 
				System.out.println("checkExit");
			}
			
			
		}); //�͸�ü�� �ٷ� �����Ͽ� ����
		
		// Runtime.getRuntime().exit(n) �˾ƺ��� ����		
		for(int i=0; i<10; i++){
			System.out.println(i);
/*			if(i==5){ // for�� 6���� ���� ����
				System.exit(0); //jvm ����
			// ��Ŀ�� �����ؼ� ���μ��� �׿����� �� ����(����)
			// ������ ���忡�� ���Ḧ ���� ���: System.exit(54321) -> exit�ȿ� �����ڸ� �˰� �ִ� ���� ��� �����ϵ��� �����ϰ�
			// ��ġ ��й�ȣ�� ����. exit(status)
			}*/
			
			
			if(i==5){
				try{
					System.exit(54321); // �����ڰ� ������ ��ȣ�� �־�� �����Ų��.
				}catch(SecurityException e){
					
				}
			}
		}
		
		
	}
	
	
	

}

/*class System{ //18�� ����
	public static PrintStream out; ->println()
	public static InputStream in; -> read()
}*/

// System s = new System(); �Ұ���
// System Ŭ������ �����ڿ� private �پ��ֱ� ������ �Ⱥ��̴� ��
// System Ŭ������ �޼ҵ���� ��� static �޼ҵ��̴�. -> ��ü�� �� ����� �����ؾ� �ϱ� ������.

/*static void	exit(int status)
: Terminates the currently running Java Virtual Machine.

*Runtime.getRuntime().exit(n) ���Ȱ�����?
*
*/
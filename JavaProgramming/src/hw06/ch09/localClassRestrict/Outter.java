package hw06.ch09.localClassRestrict;

public class Outter {
	//java 7����
	public void method1(final int arg){
		final int localVariable = 1;
		//arg = 100;
		// localVariable = 100;
		
		// ���� Ŭ����
		/*class Inner(){
			public void method(){
				int result = arg + localVariable;
			}
		}*/
		
	}
	
	//java 8
	public void method2(int arg){
		int localVariable = 1;
		//arg = 100;
		//localVariable = 100;
		
		class Inner{
			public void method(){
				int result = arg + localVariable;
			}
		}
	}
	
	
	
	
	
}

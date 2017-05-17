package ch11.exam04;
// 2017.04.04 수업 내용
// http://docs.oracle.com/javase/8/docs/api/index.html 도큐먼트 참조
public class SystemExample {
	
	public static void main(String[] args) {
		
		System.setSecurityManager(new SecurityManager(){
			//재정의
			@Override
			public void checkExit(int status) {  //throws 없어도 되는 이유: 실행예외라서
				if(status!=54321) // 예외 발생시켜 정상 종료 아닐 때 출력되게
					throw new SecurityException(); // 
				System.out.println("checkExit");
			}
			
			
		}); //익명객체로 바로 생성하여 대입
		
		// Runtime.getRuntime().exit(n) 알아보는 예제		
		for(int i=0; i<10; i++){
			System.out.println(i);
/*			if(i==5){ // for문 6번만 돌면 끝남
				System.exit(0); //jvm 종료
			// 해커가 잠입해서 프로세스 죽여버릴 수 있음(보안)
			// 개발자 입장에서 종료를 막는 방법: System.exit(54321) -> exit안에 개발자만 알고 있는 값을 줘야 종료하도록 설정하게
			// 마치 비밀번호와 같다. exit(status)
			}*/
			
			
			if(i==5){
				try{
					System.exit(54321); // 개발자가 지정한 번호를 넣어야 종료시킨다.
				}catch(SecurityException e){
					
				}
			}
		}
		
		
	}
	
	
	

}

/*class System{ //18장 내용
	public static PrintStream out; ->println()
	public static InputStream in; -> read()
}*/

// System s = new System(); 불가능
// System 클래스의 생성자에 private 붙어있기 때문에 안보이는 것
// System 클래스의 메소드들은 모두 static 메소드이다. -> 객체를 안 만들고 접근해야 하기 때문에.

/*static void	exit(int status)
: Terminates the currently running Java Virtual Machine.

*Runtime.getRuntime().exit(n) 보안과관련?
*
*/
package ch11.exam06;
//2017.04.04 수업 내용

public class TimeExample { //시간 측정예제
	public static void main(String[] args) {
		
		int sum=0;
//		long startTime = System.currentTimeMillis(); // 현재 시간의 long값을 리턴하는 메소드
		long startTime = System.nanoTime(); 
		//시간인데 long값 나오는 이유 : Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object.
		//1970년에 표준시 제정
		
		for(int i=0;i<10000000;i++){
			sum+=i;
		}
//		long endTime = System.currentTimeMillis();
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime); //1/10^9
	}
}
// OS에서 얻을 수 있는 정보들
// 현재 login한 사용자, OS의 종류, 현재 자바의 버전, 환경변수 등
package ch11.exam08;
//2017.04.04 수업 내용

// 이 예제 응용처: 주어진 문ㄴ자열에서 어떤 단어나 어떤 문장을 검색할 때
public class StringIndexOfExample {
	public static void main(String[] args) {
		String subject = "자비 프로그래밍";
		
		int location = subject.indexOf("프로그라밍"); //contains() 대체제로 사용 가능
		System.out.println(location); //인덱스의 시작 위치 출력
		
		if(subject.indexOf("자바") != -1) // 주어진 문자열이 포함되어 있으면
			System.out.println("자바와 관련된 책이다");
		else
			System.out.println("자바와 관련없는 책이다");
	
	}
}

package ch11.exam10;
//2017.04.05 수업 내용
import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		String text = "홍길동/이수홍/박연수";
		
		// 방법1 : 전체 토큰수를 받아와서
		// 스트링, 구분자를 받아옴
		StringTokenizer st = new StringTokenizer(text, "/");
		int countTokens = st.countTokens(); //꺼내지 않고 남아있는 토큰의 수를 대입
		for(int i=0; i<countTokens;i++){ //토큰의 수 만큼 반복문
			String token = st.nextToken(); // 다음 토큰까지 받아온다
			System.out.println(token); //받아온 토큰 내용을 출력한다
		}
		
		System.out.println(); // 밑줄 한칸 띄고
		
		// 방법2 : 남아있는 토큰이 먼저 있는지 검사한 후
		st = new StringTokenizer(text, "/"); // 
		while(st.hasMoreTokens()){// 남아있는 토큰을 확인하고 while문으로 루핑
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}

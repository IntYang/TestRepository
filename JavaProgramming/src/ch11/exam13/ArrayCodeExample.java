package ch11.exam13;
//2017.04.05 수업 내용
import java.util.Arrays;

public class ArrayCodeExample {
	public static void main(String[] args) {
		char[] arr1 = {'J','A','V','A'};
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr2)); //매개값 항목을 문자로 출력해주는 역할: toString
		//배열의 항목을 문자열롬 ㅏㄴ들어 출력하기때문에 상당히 편리하다, 반복문이 필요없다
		
		char[] arr3 = Arrays.copyOfRange(arr1, 1, 3);
		System.out.println(Arrays.toString(arr3));
		
		char[] arr4 = new char[arr1.length];
		System.arraycopy(arr1,0,arr4,0,arr1.length); // 원본배열,원본 시작 인덱스,타겟배열, 타겟시작인덱스, 복사개수
		for(int i=0;i<arr4.length;i++)
			System.out.println("arr4[" + i + "]=" + arr4[i]);
	
	
	}
}

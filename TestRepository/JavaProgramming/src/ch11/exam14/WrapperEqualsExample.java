package ch11.exam14;
// 2017.04.05 수업 내용 
public class WrapperEqualsExample {
	public static void main(String[] args) {
		/*Integer v1 = new Integer(10);
		Integer v2 = new Integer(10);
		*/
		/*Integer v1 = 10;
		Integer v2 = 10;*/
		
		Integer v1 = 1000;
		Integer v2 = 1000;
		
		System.out.println(v1 == v2); //false
		//기본타입이 아닐 경우 값 비교시 == 절대 쓰지 말고, equals()쓸 것!!
		
		System.out.println(v1.intValue() == v2.intValue());
		//요즘에 잘 안쓰는 방법
		
		System.out.println(v1.equals(v2));
		
		
		
	}
}

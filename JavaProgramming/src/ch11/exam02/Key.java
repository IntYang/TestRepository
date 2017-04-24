package ch11.exam02;
//2017.04.04 수업내용
public class Key {
	private int number;
	
	public Key(int number){
		this.number = number;
	}
	
	//키 번호가 같다면 같은 걸로 간주하게 수정하는 방법
	// 해시코드 재정의 &&
	// equals() 재정의
	
	@Override
	public int hashCode() {
		return number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key){ //  Member 객체가 들어오면
			Key target = (Key) obj; //강제 타입 변환하는 이유: 자식 객체 쓸 수 있도록
			if(number == target.number)
				return true;
		}
		
		return false;
	
	}
	
}

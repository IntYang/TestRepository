package ch11.exam01;
//2017.04.04 수업내용
public class Member {
	//Field
	private String id;
	
	//Constructor
	public Member(String id){
		this.id = id;
	}
	
	//Method 재정의
	@Override
	public boolean equals(Object obj) { // 매개변수에 들어오는 객체 종류: 자바의 모든 객체(자바의 모든 객체는 Object를 상속 받기 때문에
		if(obj instanceof Member){ //  Member 객체가 들어오면
			Member target = (Member) obj; //강제 타입 변환하는 이유: 자식 객체 쓸 수 있도록
			if(id.equals(target.id))
				return true;
		}
		
			return false;
	
	}
	
	
	
}

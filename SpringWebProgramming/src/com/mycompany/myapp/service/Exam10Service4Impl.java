package com.mycompany.myapp.service;

import com.mycompany.myapp.dao.Exam10Dao2;
// 고전적인 방식으로 스프링 관리 객체를 만드는 방법 - 어노테이션을 떼고 시작



//@Component - 스프링 관리 객체 아니게
public class Exam10Service4Impl implements Exam10Service4 {
	
	private Exam10Dao2 exam10Dao;
	
	//@Autowired를 붙이지 않는 이유- 자동주입 안되게
	public void setExam10Dao(Exam10Dao2 exam10Dao) {
		this.exam10Dao = exam10Dao;
	}

	//<bean id="exam10Service4" class="com.mycompany.myapp.service.Exam10Service4Impl"/> 했을 때 널포인트 익셉션 나온다
	// exam10Dao에 아무것도 넣어지지 않았음(자동주입이 아니니까)
	// 이렇게 객체 생성하면 안됨, 추가적으로 셋터 실행하도록 p태그로 작성해줘야 함
	// p:exam10Dao-ref="exam10Dao2" 넣어줘야 
	@Override
	public void join(){
		System.out.println(" Exam10Service4Impl join() 실행");
		exam10Dao.insert();
	
	}
	
	@Override
	public void login(){
		System.out.println(" Exam10Service4Impl login() 실행");
		exam10Dao.select();
	
	}
}

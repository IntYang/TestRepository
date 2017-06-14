package com.mycompany.myapp.service;

import com.mycompany.myapp.dao.Exam10Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Exam10Service2Impl implements Exam10Service2 {
	
	private Exam10Dao1 exam10Dao;
	
	// setter 주입
	@Autowired
	public void setExam10Dao2(Exam10Dao1 exam10Dao) { 
		this.exam10Dao = exam10Dao;
	}

	@Override
	public void join(){
		System.out.println(" Exam10Service2Impl join() 실행");
		exam10Dao.insert();
	
	}
	
	@Override
	public void login(){
		System.out.println(" Exam10Service2Impl login() 실행");
		exam10Dao.select();
	
	}
}
// 인터페이스, 구현 객체 왜 따로 만듦?
// 구현 클래스가 다른 클래스로 대치되어 서비스 구현하고 있다면 컨트롤러는 수정할 필요가 없음.
// 서비스가 바뀌어도 컨트롤러가 바뀌지 않게 하기 위해서이다.
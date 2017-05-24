package com.mycompany.myapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao3;


@Component
public class Exam10Service6Impl implements Exam10Service6 {
	
//	@Autowired // 타입만 보고 대입함. -> 한 인터페이스에 여러 객체 있으면 오류남(어떤 객체를 대입할지 모르는 UnsatisfiedDependencyException)
	@Resource(name="exam10Dao3ImplA") //이름 찾아 해당되는 이름의 객체를 대입해주는 역할
	private Exam10Dao3 exam10Dao; // 주입되는 객체 정확하게 주입해야
	
	@Override
	public void join(){
		System.out.println(" Exam10Service5Impl join() 실행");
		exam10Dao.insert();
	
	}
	
	@Override
	public void login(){
		System.out.println(" Exam10Service5Impl login() 실행");
		exam10Dao.select();
	
	}
}

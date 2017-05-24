
package com.mycompany.myapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class Exam10Dao3ImplA implements Exam10Dao3{

	private static final Logger logger = LoggerFactory.getLogger(Exam10Dao3ImplA.class); //private 외부로 노출 안되기에 걍 소문자 씀
	
	@Override
	public void insert(){
		//System.out.println("Exam10Dao3Impl insert() 실행");
		logger.info("회원 가입");
	}
	
	@Override
	public void select(){
		//System.out.println("Exam10Dao3Impl select() 실행");
		logger.info("회원 검색");
	}
}

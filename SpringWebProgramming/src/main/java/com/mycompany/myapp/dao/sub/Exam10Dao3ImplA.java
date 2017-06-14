
package com.mycompany.myapp.dao.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao3;
@Component("subExam10Dao3ImplA")
public class Exam10Dao3ImplA implements Exam10Dao3{ //같은 클래스, 다른 패키지 있을 수 있다. -> 관리 시 중복 오류 

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

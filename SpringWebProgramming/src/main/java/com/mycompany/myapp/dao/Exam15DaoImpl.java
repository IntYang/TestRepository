package com.mycompany.myapp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam15Account;

@Component
public class Exam15DaoImpl implements Exam15Dao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Exam15Account selectByAno(String ano) {
		Exam15Account account = sqlSessionTemplate.selectOne("account.selectByAno", ano);
		return account;
	}

	@Override
	public int update(Exam15Account account) {
		int row = sqlSessionTemplate.update("account.update", account);
		return row; // 실제 업데이트 된 행의 수
					// 업데이트 행의 수가 primary key가 아닐 경우에는 1 이상의 리턴값이 나올 수 있다
	}

}

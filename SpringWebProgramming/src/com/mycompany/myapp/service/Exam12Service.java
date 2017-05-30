package com.mycompany.myapp.service;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

public interface Exam12Service {
	public void write(Exam12Board board);
	// join 메소드 정의
	public void join(Exam12Member member);
}

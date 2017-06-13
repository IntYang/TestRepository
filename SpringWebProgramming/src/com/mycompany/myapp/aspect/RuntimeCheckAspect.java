package com.mycompany.myapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class RuntimeCheckAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RuntimeCheckAspect.class);
	
	//Pointcut : execution((public으로 되어있는 메소드들 ) (리턴타입은 상관없고) (어디서))
	@Pointcut("execution(public * com.mycompany.myapp.controller.Exam12DBController.*(..))") // ..의미: 매개변수의 수가 상관없다
	private void runtimeCheckMethod(){} // 의미는 전혀 없지만 어노테이션의 적용대상이 있어야 하기 때문에
	
	//Adivce
	@Around("runtimeCheckMethod()") // 적용할 메소드 명-> 어노테이션 포인트컷이 적용되는 메소드 식별이름 을 Around()안에 넣어준다
	public Object runtimeCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		
		// before code
		long startTime = System.nanoTime();
		
		// 실제 메소드 호출
		Object result = joinPoint.proceed(); // 실제 호출해야할 메소드(realMethod)를 호출
		
		// after code들
		long endTime = System.nanoTime();
		//걸린시간
		long time = endTime - startTime;
		//실제 실행되는 메소드의 이름을 보기
		String realMethod = joinPoint.getSignature().toShortString();
		LOGGER.info(realMethod + " 실행시간: " + time +"ns");
		
		return result;
	}
	
	

}

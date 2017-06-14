package com.mycompany.myapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Component
@Aspect

public class LoginCheckAspect {
	//Pointcut
	@Pointcut("execution(public * com.mycompany.myapp.controller.Exam14AopController.exam02*(..))")
	private void exam02Method(){}
	
	@Around("exam02Method()") // 적용할 메소드 명-> 어노테이션 포인트컷이 적용되는 메소드 식별이름 을 Around()안에 넣어준다
	public Object runtimeCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		
		// before code
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		String mid = (String)requestAttributes.getAttribute("mid", RequestAttributes.SCOPE_SESSION);
		if(mid == null){
			requestAttributes.setAttribute("loginNeed", "로그인이 필요합니다.", RequestAttributes.SCOPE_REQUEST);
			//requestAttributes.setAttribute("loginNeed", "로그인이 필요합니다.");
			//session.setAttribute(SCOPE_REQUEST);
			
			return "aop/exam02LoginForm";
		}
		else{// 실제 메소드(RealMethod) 호출
			
			Object result = joinPoint.proceed();
			return result;
			
		}
		
		// after code들
		
	}
	
	
	//Advice

}

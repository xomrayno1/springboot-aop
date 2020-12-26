package com.tampro.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BankAspect {

	
	
	@Around(value="execution(* com.tampro.service.BankService.*(..))")
	public void aroudAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// trước khi method chạy
		System.out.println(" The method aroudAdvice() before invokation of the method " + joinPoint.getSignature() + "method");
		
		try {
			joinPoint.proceed(); // gọi để method tiếp tục tiến hànhs
		} catch (Exception e) {
			// TODO: handle exception
		}
		// sau khi method chạy
		System.out.println("The method aroundAdvice() after invokation of the method " + joinPoint.getSignature().getName() + " method");
		 
	}
	
}

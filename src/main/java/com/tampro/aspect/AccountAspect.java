package com.tampro.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.tampro.model.Account;

@Aspect
@Component
public class AccountAspect {
	@AfterReturning(value="execution(* com.tampro.service.AccountServiceImpl.*(..))",returning="account")
	public void afterReturningAdvice(JoinPoint joinPoint, Account account){
		System.out.println("After Returing method:"+joinPoint.getSignature());
		System.out.println(account);
	}
	@AfterThrowing(value="execution(* com.tampro.service.AccountServiceImpl.*(..))",throwing="exception")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception exception) { 
		// thăng này chạy và nó cũng nhận qua exception , rồi tiếp theo phía bên gọi hàm mới nhận được lỗi
		System.out.println("After Throwing exception in method:"+joinPoint.getSignature());
		System.out.println("Exception is:"+exception.getMessage());
	}
}

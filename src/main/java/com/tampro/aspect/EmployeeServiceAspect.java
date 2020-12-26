package com.tampro.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {
	//http://localhost:8080/add/employee?empId=1&firstName=Nguyen&secondName=ChiTam
	@Before(value = "execution(* com.tampro.service.EmployeeService.*(..)) and args(empId,firstName,secondName)")
	//@Before(value = “execution(* com.javatpoint.service.EmployeeService.*(..)) and args(empId, fname, sname)”)
	public void beforeAdviceCreate(JoinPoint joinPoint , String empId , String firstName, String secondName) {
		System.out.println("before method : "+joinPoint.getSignature());
		System.out.println("create employee with first name - " + firstName + ", second name - "+secondName + ", and id "+ empId);
	}
	
	@Before(value = "execution(* com.tampro.service.EmployeeService.*(..)) and args(empId)")
	//@Before(value = “execution(* com.javatpoint.service.EmployeeService.*(..)) and args(empId)”)
	public void beforeAdviceRemove(JoinPoint joinPoint , String empId ) {
		System.out.println("before method : "+joinPoint.getSignature());
		System.out.println("delete employee with empId - " +empId);
	}
}

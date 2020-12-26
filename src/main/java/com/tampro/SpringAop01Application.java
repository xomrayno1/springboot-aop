package com.tampro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.tampro.model.Account;
import com.tampro.service.AccountService;
import com.tampro.service.AccountServiceImpl;
import com.tampro.service.BankService;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringAop01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context  =  SpringApplication.run(SpringAop01Application.class, args);
		
		//fetching the employee  object from the application context
		 
		BankService bankService = context.getBean(BankService.class);
		
		//display balance in the account
		
		 

		String accountNumber = "12345";
		//trước khi chạy thằng này nó sẽ gọi đến @around
		bankService.displayBalance(accountNumber);
		
		System.out.println("=========@After returning========");
		
		AccountService accountService = context.getBean(AccountServiceImpl.class);
		Account account;
		try {
			account = accountService.getAccountByCustomerId("K2434567");
			if(account != null) {
				System.out.println(account.getAccountNumber()+"\t"+account.getAccountType());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("=========@After Throwing========");
		 
		try {
			account = accountService.getAccountByCustomerId(null);
			if(account != null) {
				System.out.println(account.getAccountNumber()+"\t"+account.getAccountType());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()); // sau khi thằng @After throwing xử lý xong bên này mới nhận
		}
		//closing the context in object	
		context.close();
		
	}

}

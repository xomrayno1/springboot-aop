package com.tampro.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tampro.model.Account;

@Service
public class AccountServiceImpl  implements AccountService{
	
	private static Map<String ,Account> map = null;
	static {
		map = new HashMap<>();
		//adding account detail in the map
		map.put("M4546779", new Account("10441117000", "Saving Account"));
		map.put("K2434567", new Account("10863554577", "Current Account"));
	}
	@Override
	public Account getAccountByCustomerId(String customerId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("====get account====");
		if(customerId ==null){
			throw new Exception("Invalid! Customer Id"); 
			// quăng ra chưa nhận dc thì thằng @After throwing đã chạy
		}
		Account account= null;
		Set<Entry<String, Account>> entrySet = map.entrySet();
		for (Entry<String, Account> entry : entrySet){
			if(entry.getKey().equals(customerId)){
				account= entry.getValue();
			}
		}
		return account; // sau khi return là thằng after returning nó chạy luôn
		 
	}
}

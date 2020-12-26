package com.tampro.service;

import com.tampro.model.Account;

public interface AccountService {
	public abstract Account getAccountByCustomerId(String customerId)
			throws Exception;
}

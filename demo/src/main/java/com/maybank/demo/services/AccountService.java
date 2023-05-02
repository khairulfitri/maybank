package com.maybank.demo.services;

import java.util.List;

import com.maybank.demo.entities.Account;

public interface AccountService {
	public List<Account> findByAccountNumber(String accountNo);
	
	public List<Account> findByCustomerId(String customerId);
	
	public List<Account> findByDescription(String description);
	
}


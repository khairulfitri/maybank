package com.maybank.demo.services;

import java.util.List;

import com.maybank.demo.entities.AccountTransaction;

public interface AccountTransactionService {
	public List<AccountTransaction> findByAccountNumber(String accountNo);
	
	public List<AccountTransaction> findByCustomerId(String customerId);
	
	public List<AccountTransaction> findByDescription(String description);
	
	public AccountTransaction updateAccount(AccountTransaction account);
	
}


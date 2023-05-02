package com.maybank.demo.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.maybank.demo.entities.AccountTransaction;

public interface AccountTransactionService {
	public List<AccountTransaction> findByAccountNumber(String accountNo, Pageable pageable);
	
	public List<AccountTransaction> findByCustomerId(String customerId, Pageable pageable);
	
	public List<AccountTransaction> findByDescription(String description, Pageable pageable);
	
	public AccountTransaction updateAccount(AccountTransaction account);

}


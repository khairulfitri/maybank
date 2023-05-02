package com.maybank.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.demo.entities.Account;
import com.maybank.demo.repositories.AccountRepository;
import com.maybank.demo.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Account> findByAccountNumber(String accountNo) {
		List<Account> result = accountRepository.findByAccountNumber(accountNo);
		
		if (result.size() > 0 )
			return result;
		else {
			ArrayList<Account> list = new ArrayList<Account>();
			Account account = new Account();
			account.setAccountNumber(Long.valueOf(accountNo));
			account.setDescription("Account not found");
			list.add(account);
			return list;
		}
	}

	@Override
	public List<Account> findByCustomerId(String customerId) {
		List<Account> result = accountRepository.findByCustomerId(customerId);
		
		if (result.size() > 0 )
			return result;
		else {
			ArrayList<Account> list = new ArrayList<Account>();
			Account account = new Account();
			account.setCustomerId(customerId);
			account.setDescription("Account not found");
			list.add(account);
			return list;
		}
	}

	@Override
	public List<Account> findByDescription(String description) {
		List<Account> result = accountRepository.findByDescription(description);
		
		if (result.size() > 0 )
			return result;
		else {
			ArrayList<Account> list = new ArrayList<Account>();
			Account account = new Account();
			account.setDescription("Account not found for description : "+description);
			list.add(account);
			return list;
		}
	}

}

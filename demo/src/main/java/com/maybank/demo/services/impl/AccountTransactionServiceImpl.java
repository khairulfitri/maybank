package com.maybank.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.maybank.demo.entities.AccountTransaction;
import com.maybank.demo.repositories.AccountTransactionRepository;
import com.maybank.demo.services.AccountTransactionService;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {
    Logger logger = LoggerFactory.getLogger(AccountTransactionServiceImpl.class);

	@Autowired
	AccountTransactionRepository accountRepository;

	@Override
	public List<AccountTransaction> findByAccountNumber(String accountNo, Pageable pageable) {
		logger.debug("findByAccountNumber : {}, pageable : {}", accountNo, pageable);
		
		List<AccountTransaction> result = accountRepository.findByAccountNumber(accountNo, pageable);
		
		if (result.size() > 0 )
			return result;
		else {
			ArrayList<AccountTransaction> list = new ArrayList<AccountTransaction>();
			AccountTransaction account = new AccountTransaction();
			account.setAccountNumber(Long.valueOf(accountNo));
			account.setDescription("Account not found");
			list.add(account);
			return list;
		}
	}

	@Override
	public List<AccountTransaction> findByCustomerId(String customerId, Pageable pageable) {
		logger.debug("findByCustomerId : {}, pageable : {}", customerId, pageable);

		List<AccountTransaction> result = accountRepository.findByCustomerId(customerId, pageable);
		
		if (result.size() > 0 )
			return result;
		else {
			ArrayList<AccountTransaction> list = new ArrayList<AccountTransaction>();
			AccountTransaction account = new AccountTransaction();
			account.setCustomerId(customerId);
			account.setDescription("Account not found");
			list.add(account);
			return list;
		}
	}

	@Override
	public List<AccountTransaction> findByDescription(String description, Pageable pageable) {
		logger.debug("findByDescription : {}, pageable : {}", description, pageable);

		List<AccountTransaction> result = accountRepository.findByDescription(description, pageable);
		
		if (result.size() > 0 )
			return result;
		else {
			ArrayList<AccountTransaction> list = new ArrayList<AccountTransaction>();
			AccountTransaction account = new AccountTransaction();
			account.setDescription("Account not found for description : "+description);
			list.add(account);
			return list;
		}
	}

	@Override
	public AccountTransaction updateAccount(AccountTransaction account) {
		logger.debug("accountString : {} ", account.toString());

		AccountTransaction retrievedAccount;
		
		Optional<AccountTransaction> getAccount = accountRepository.findById(account.getId());
		if (getAccount.isPresent()) {
			retrievedAccount = getAccount.get();
			retrievedAccount.setDescription(account.getDescription());
			accountRepository.save(retrievedAccount);
			
			return accountRepository.findById(retrievedAccount.getId()).get();
			
		} else {
			retrievedAccount = new AccountTransaction();
			retrievedAccount.setId(account.getId());
			retrievedAccount.setDescription("Account not found for id : "+account.getId());
			return retrievedAccount;
		}
	}


}

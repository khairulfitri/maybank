package com.maybank.demo.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.demo.entities.AccountTransaction;
import com.maybank.demo.repositories.AccountTransactionRepository;
import com.maybank.demo.services.AccountTransactionService;

//@Api(tags = "Account")
@RequestMapping(value = "/transaction/", produces = "application/json")
@RestController
public class AccountTransactionController {
    Logger logger = LoggerFactory.getLogger(AccountTransactionController.class);

	
	@Autowired 
	AccountTransactionRepository accountRepository;
	
	@Autowired
	AccountTransactionService accountService;
	
	@GetMapping("/employees")
	public String testController() {
		return "Hello World";
	}
	
	@GetMapping("/findByAccountNumber/{accountNo}")
	public List<AccountTransaction> getAccountByAccountNumber(@PathVariable("accountNo") String accountNo, Pageable pageable) {
		return accountService.findByAccountNumber(accountNo, pageable);
	}
	
	@GetMapping("/findByCustomerId/{customerId}")
	public List<AccountTransaction> getAccountByCustomerId(@PathVariable("customerId") String customerId, Pageable pageable) {
		return accountService.findByCustomerId(customerId, pageable);
	}
	
	@GetMapping("/findByDescription/{description}")
	public List<AccountTransaction> getAccountByDescription(@PathVariable("description") String description, Pageable pageable) {
		return accountService.findByDescription(description, pageable);
	}
	
	@PutMapping("/update/")
	public AccountTransaction updateAccount(@RequestBody AccountTransaction account) {
		return accountService.updateAccount(account);
	}
}


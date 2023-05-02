package com.maybank.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.demo.entities.Account;
import com.maybank.demo.repositories.AccountRepository;
import com.maybank.demo.services.AccountService;

import io.swagger.annotations.Api;

@Api(tags = "Account")
@RestController
//@RequestMapping(value = "/rbs/account", produces = "application/json")
public class AccountController {
    Logger logger = LoggerFactory.getLogger(AccountController.class);

	
	@Autowired 
	AccountRepository accountRepository;
	
	@Autowired
	AccountService accountService;
//	
//	@Autowired
//	AccountRepository repos;
//	
//	@Autowired
//	SubscriptionService subscriptionService;
	
//	@ApiOperation("${account.endpoints.create-billing-account}")
//	@PostMapping("/createBillingAccount")
//	void createBillingAccount(@RequestBody @ApiParam("${default-descriptions.request-body}") CreateNewBillingAccount request){
//		return accountService.createBillingAccount(request);
//	}
//	
////	@ApiOperation("${account.endpoints.register-sub-account}")
////	@PostMapping("/registerSubAccount")
////	RegisterSubAccountOut registerSubAccount(@RequestBody @ApiParam("${default-descriptions.request-body}") RegisterSubAccount request){
////		return accountService.registerSubAccount(request);
////	}
//	
//	@ApiOperation("${account.endpoints.update-account-information}")
//	@PostMapping("/updateAccountInformation")
//	CreateNewBillingAccountOut updateAccountInformation(@RequestBody @ApiParam("${default-descriptions.request-body}") UpdateAccount request){
//		return subscriptionService.updateAccountInformation(request);
//	}
//	
//	@ApiOperation("${account.endpoints.update-account-information}")
//	@PostMapping("/transferAccountInformation")
//	CreateNewBillingAccountOut transferAccount(@RequestBody @ApiParam("${default-descriptions.request-body}") CreateNewBillingAccount request){
//		return accountService.transferAccount(request);
//	}
//	
//	@GetMapping("/{accountNo}")
//	public AccountOut getAccount(@PathVariable("accountNo") String accountNo){
//		return accountService.findByAccountNumber(accountNo);
//	}
	
	@GetMapping("/employees")
	public String testController() {
		return "Hello World";
	}
	
	@GetMapping("/account/findByAccountNumber/{accountNo}")
	public List<Account> getAccountByAccountNumber(@PathVariable("accountNo") String accountNo) {
		return accountService.findByAccountNumber(accountNo);
	}
	
	@GetMapping("/account/findByCustomerId/{customerId}")
	public List<Account> getAccountByCustomerId(@PathVariable("customerId") String customerId) {
		return accountService.findByCustomerId(customerId);
	}
	
	@GetMapping("/account/findByDescription/{description}")
	public List<Account> getAccountByDescription(@PathVariable("description") String description) {
		return accountService.findByDescription(description);
	}
	
	@PostMapping("/loadData/")
	public List<Account> loadData(@PathVariable("accountNo") String accountNo) {
		return accountService.findByAccountNumber(accountNo);
	}
}


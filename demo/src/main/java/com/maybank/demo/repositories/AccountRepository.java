package com.maybank.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.maybank.demo.entities.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {
	List<Account> findByAccountNumber(String accountNo);
	
	List<Account> findByCustomerId(String customerId);
	
	List<Account> findByDescription(String description);


}

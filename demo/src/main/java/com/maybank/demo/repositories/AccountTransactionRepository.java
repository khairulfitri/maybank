package com.maybank.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.maybank.demo.entities.AccountTransaction;


public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
	List<AccountTransaction> findByAccountNumber(String accountNo);
	
	List<AccountTransaction> findByCustomerId(String customerId);
	
	List<AccountTransaction> findByDescription(String description);


}

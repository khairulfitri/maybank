package com.maybank.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account_transaction")
public class AccountTransaction {
	
	public AccountTransaction(Long accountNumber, Long customerId, Double transactionAmount, String description,
			String transactionDate) {
		super();
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.transactionAmount = transactionAmount;
		this.description = description;
		this.transactionDate = transactionDate;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    
	@Column(name="account_number")
	private Long accountNumber;
		
	@Column(name="customer_id")
	private Long customerId;
	
	@Column(name="trx_amount")
	private Double transactionAmount;
	
	@Column(name="description")
	private String description;
	
	@Column(name="trx_date")
	private String transactionDate;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerId=" + customerId + ", transactionAmount="
				+ transactionAmount + ", description=" + description + ", transactionDate=" + transactionDate + "]";
	}
	
}

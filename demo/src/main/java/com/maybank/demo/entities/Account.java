package com.maybank.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="account_number")
	private Long accountNumber;
		
	@Column(name="customer_id")
	private String customerId;
	
	@Column(name="trx_amount")
	private Double transactionAmount;
	
	@Column(name="description")
	private String description;
	
	@Column(name="trx_date")
	private String transactionDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
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
		return "Account [id =" + id + ", accountNumber=" + accountNumber + ", customerId=" + customerId + ", transactionAmount="
				+ transactionAmount + ", description=" + description + ", transactionDate=" + transactionDate + "]";
	}
}

package com.capgemini.bankapp.bean;

import java.time.LocalDate;
import java.util.List;

public class AccountDetails {

	
	public CustomerDetails customer;

	private List<String> pTrans;
	
	

	private long accountNumber;
	private String password;
	private LocalDate date;
	private int transID;
	private double balance;
	private double withdraw;
	private double deposit;

	
	@Override
	public String toString() {
		return "AccountDetails [customer=" + customer + ", accountNumber=" + accountNumber + ", password=" + password
				+ ", date=" + date + ", transId=" + transID + ", balance=" + balance + ", withdraw=" + withdraw
				+ ", deposit=" + deposit + "]";
	}
	
	public List<String> getpTrans() {
		return pTrans;
	}

	public void setpTrans(List<String> pTrans) {
		this.pTrans = pTrans;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}

	
	
	
}
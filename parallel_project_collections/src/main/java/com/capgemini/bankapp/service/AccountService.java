package com.capgemini.bankapp.service;

import java.util.List;

import com.capgemini.bankapp.bean.AccountDetails;
import com.capgemini.bankapp.dao.AccountDAO;

public class AccountService implements IAccountService {
	
	AccountDAO dao = new AccountDAO();

	
	public boolean addAccountDetails(AccountDetails account) {

		return dao.addAccountDetails(account);
	}


	public Double showBalance() {

		return dao.showBalance();
	}

	
	public boolean deposit(double amount) {

		return dao.deposit(amount);
	}

	
	public boolean withdraw(double amount) {

		return dao.withdraw(amount);
	}

	
	public boolean printTransaction() {

		return dao.printTransaction();
	}

	
	public boolean fundTransfer(long payeeAccountNumber, double amount) {

		return dao.fundTransfer(payeeAccountNumber, amount);
	}

	
	public boolean testLogin(long accountNumber, String password) {

		return dao.testLogin(accountNumber, password);
	}


}

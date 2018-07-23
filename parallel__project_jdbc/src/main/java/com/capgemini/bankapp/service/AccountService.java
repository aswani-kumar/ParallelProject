package com.capgemini.bankapp.service;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.bankapp.bean.AccountDetails;
import com.capgemini.bankapp.dao.AccountDAO;

public class AccountService implements IAccountService {
	
	AccountDAO dao = new AccountDAO();

	
	public boolean addAccountDetails(AccountDetails account) throws SQLException {

		return dao.addAccountDetails(account);
	}


	public Double showBalance() throws SQLException {

		return dao.showBalance();
	}

	
	public boolean deposit(double amount) throws SQLException {

		return dao.deposit(amount);
	}

	
	public boolean withdraw(double amount) throws SQLException {

		return dao.withdraw(amount);
	}

	
	public boolean printTransaction() throws SQLException, ClassNotFoundException {

		return dao.printTransaction();
	}

	
	public boolean fundTransfer(long payeeAccountNumber, double amount) throws SQLException {

		return dao.fundTransfer(payeeAccountNumber, amount);
	}

	
	public boolean testLogin(long accountNumber, String password) throws SQLException {

		return dao.testLogin(accountNumber, password);
	}


}

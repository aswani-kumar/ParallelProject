package com.capgemini.bankapp.dao;

import java.util.List;

import com.capgemini.bankapp.bean.AccountDetails;

public interface IAccountDAO {

	boolean testLogin(long accountNumber, String password);

	boolean addAccountDetails(AccountDetails account);

	double showBalance();

	boolean deposit(double amount);

	boolean withdraw(double amount);

	boolean printTransaction();

	boolean fundTransfer(long payeeAccountNumber, double amount);
}


package com.capgemini.bankapp.service;

import java.util.List;

import com.capgemini.bankapp.bean.AccountDetails;

public interface IAccountService {
	boolean testLogin(long accountNumber, String password);

	boolean addAccountDetails(AccountDetails account);

	Double showBalance();

	boolean deposit(double amount);

	boolean withdraw(double amount);

	boolean printTransaction();

	boolean fundTransfer(long payeeAccountNumber, double amount);
}

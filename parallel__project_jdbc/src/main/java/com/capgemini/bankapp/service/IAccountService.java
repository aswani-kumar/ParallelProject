package com.capgemini.bankapp.service;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.bankapp.bean.AccountDetails;

public interface IAccountService {
	boolean testLogin(long accountNumber, String password) throws SQLException;

	boolean addAccountDetails(AccountDetails account) throws SQLException;

	Double showBalance() throws SQLException;

	boolean deposit(double amount) throws SQLException;

	boolean withdraw(double amount) throws SQLException;

	boolean printTransaction() throws SQLException, ClassNotFoundException;

	boolean fundTransfer(long payeeAccountNumber, double amount) throws SQLException;
}

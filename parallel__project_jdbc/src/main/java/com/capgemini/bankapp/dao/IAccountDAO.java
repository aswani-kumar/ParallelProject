package com.capgemini.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.bankapp.bean.AccountDetails;

public interface IAccountDAO {

	boolean testLogin(long accountNumber, String password) throws SQLException;

	boolean addAccountDetails(AccountDetails account) throws SQLException;

	double showBalance() throws SQLException;

	boolean deposit(double amount) throws SQLException;

	boolean withdraw(double amount) throws SQLException;

	boolean printTransaction() throws ClassNotFoundException, SQLException;

	boolean fundTransfer(long payeeAccountNumber, double amount) throws SQLException;
}


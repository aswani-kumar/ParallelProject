package com.capgemini.bankapp.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.capgemini.bankapp.bean.AccountDetails;

public class AccountDAO implements IAccountDAO {
	
	
	AccountDetails login = new AccountDetails();
	AccountDetails details = new AccountDetails();

	static List<AccountDetails> list = new ArrayList<AccountDetails>();
	static List<String> list1 = new ArrayList<String>();
	
	
	static HashMap<Long, AccountDetails> hm = new HashMap<Long, AccountDetails>();
	
	

	
	public boolean addAccountDetails(AccountDetails account) {

		boolean b = list.add(account);
		if (b) {

			return true;
		} else {
			return false;
		}

	}

	
	public boolean testLogin(long accountNumber, String password) {

		Iterator<AccountDetails> it = list.iterator();
		while (it.hasNext()) {

			AccountDetails accountDetails = (AccountDetails) it.next();
			if (accountDetails.getAccountNumber() == accountNumber) {

				if (accountDetails.getPassword().equals(password)) {

					login.setAccountNumber(accountNumber);

					return true;
				}
			}
		}
		return false;

	}

	
	public double showBalance() {

		Iterator<AccountDetails> it = list.iterator();
		while (it.hasNext()) {
			AccountDetails accountDetails = (AccountDetails) it.next();
			if (accountDetails.getAccountNumber() == login.getAccountNumber()) {
				return accountDetails.getBalance();
			}
		}

		return 0;
	}


	public boolean deposit(double amount) {

		Iterator<AccountDetails> it = list.iterator();
		while (it.hasNext()) {

			AccountDetails accountDetails = (AccountDetails) it.next();
			if (accountDetails.getAccountNumber() == login.getAccountNumber()) {
				accountDetails.setDeposit(amount);
				double b = accountDetails.getBalance() + accountDetails.getDeposit();
				accountDetails.setBalance(b);
				
				String s1 = "The "+amount+"is deposited to "+login.getAccountNumber();
				
				accountDetails.getpTrans().add(s1);
				
				return true;
			}

		}

		return false;

	}

	
	public boolean withdraw(double amount) {

		Iterator<AccountDetails> it = list.iterator();
		while (it.hasNext()) {

			AccountDetails accountDetails = (AccountDetails) it.next();
			if (accountDetails.getAccountNumber() == login.getAccountNumber()) {
				accountDetails.setWithdraw(amount);
				if(amount+500<accountDetails.getBalance()) {
				double b = accountDetails.getBalance() - accountDetails.getWithdraw();
				accountDetails.setBalance(b);
				
				String s1 = "The "+amount+"is withdrawn "+login.getAccountNumber();
				
				accountDetails.getpTrans().add(s1);
			
				return true;
				} 
			}

		}

		return false;
	}

	
	public boolean  printTransaction() {
	
		Iterator<AccountDetails> it = list.iterator();
		while (it.hasNext()) {
			AccountDetails accountDetails = (AccountDetails) it.next();
			if(accountDetails.getAccountNumber() == login.getAccountNumber()) {
				System.out.println(accountDetails.getpTrans());
			}
		}
				
		return false;
	}
		
		
		
		
	

	
	public boolean fundTransfer(long payeeAccountNumber, double amount) {

		
		Iterator<AccountDetails> it = list.iterator();
		while (it.hasNext()) {

			AccountDetails accountDetails = (AccountDetails) it.next();
			if (accountDetails.getAccountNumber() == login.getAccountNumber()) {
				accountDetails.setWithdraw(amount);
				double b = accountDetails.getBalance() - accountDetails.getWithdraw();
				accountDetails.setBalance(b);

				

				String s1 = "The "+amount+"is deposited to "+login.getAccountNumber();
				
				accountDetails.getpTrans().add(s1);
				
				
			}
		}
		
		Iterator<AccountDetails> it1 = list.iterator();
		while (it1.hasNext()) {
			AccountDetails accountDetails = (AccountDetails) it1.next();
			if (accountDetails.getAccountNumber() == payeeAccountNumber) {
				accountDetails.setDeposit(amount);
				double b = accountDetails.getBalance() + accountDetails.getDeposit();
				accountDetails.setBalance(b);

				

				String s1 = "The "+amount+"is deposited to "+payeeAccountNumber;
				
				accountDetails.getpTrans().add(s1);
				
				
				
				return true;
			} 
		}

		return false;

	}

}
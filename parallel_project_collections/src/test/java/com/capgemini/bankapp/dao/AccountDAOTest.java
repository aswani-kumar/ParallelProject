package com.capgemini.bankapp.dao;

import com.capgemini.bankapp.bean.AccountDetails;
import com.capgemini.bankapp.service.AccountService;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AccountDAOTest extends TestCase {

	AccountDetails details = new AccountDetails();
	AccountService service = new AccountService();

	public void testAddAccountDetails() {
		Assert.assertNotNull(details);
		Assert.assertNull(details);
	}

	public void testShowBalance() {
		Assert.assertEquals("", details.getBalance());
		Assert.assertNull(details);
	}

	public void testDeposit() {
		Assert.assertEquals(0, service.deposit(500));
		Assert.assertTrue(true);
		Assert.assertNull(details);

	}

	public void testWithdraw() {

		Assert.assertEquals(0, service.withdraw(500));
		Assert.assertTrue(true);
		Assert.assertNull(details);
	}

	

	public void testFundTransfer() {
		Assert.assertEquals(0, service.fundTransfer(10001010, 500));
		Assert.assertNull(details);
	}

}

package com.capgemini.bankapp.service;

import java.sql.SQLException;

import com.capgemini.bankapp.bean.AccountDetails;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AccountServiceTest extends TestCase {

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

	public void testDeposit() throws SQLException {
		Assert.assertEquals(0, service.deposit(500));
		Assert.assertTrue(true);
		Assert.assertNull(details);

	}

	public void testWithdraw() throws SQLException {

		Assert.assertEquals(0, service.withdraw(500));
		Assert.assertTrue(true);
		Assert.assertNull(details);
	}

	public void testPrintTransaction() throws ClassNotFoundException, SQLException {
		Assert.assertEquals(false, service.printTransaction());
		Assert.assertNotSame(true, service.printTransaction());
	}

	public void testFundTransfer() throws SQLException {
		Assert.assertEquals(0, service.fundTransfer(10001010, 500));
		Assert.assertNull(details);
	}
}

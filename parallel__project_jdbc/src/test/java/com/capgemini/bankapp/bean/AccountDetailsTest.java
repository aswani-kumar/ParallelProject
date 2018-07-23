package com.capgemini.bankapp.bean;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AccountDetailsTest extends TestCase {

	AccountDetails details = new AccountDetails();
	CustomerDetails custDetails= new CustomerDetails();

	public void testGetFullName(){

		custDetails.setFullName("aswani");

		Assert.assertEquals("aswani", custDetails.getFullName());
		Assert.assertNotSame("kumar", custDetails.getFullName());
		Assert.assertEquals("aswani kumar",custDetails.getFullName());
	}

	public void testGetPassword() {

		details.setPassword("aswani@152653");

		Assert.assertEquals("aswani@152653", details.getPassword());
		Assert.assertEquals("aswani", details.getPassword());
		Assert.assertNotSame("kumar", details.getPassword());
	}

	public void testGetGender() {
		custDetails.setGender("Male");
		Assert.assertEquals("Male", custDetails.getGender());
		Assert.assertNotSame("kumar", custDetails.getGender());
	}

	public void testGetAge() {
		custDetails.setAge(24);
		Assert.assertEquals(24, custDetails.getAge());
		Assert.assertNotSame(12, custDetails.getAge());
		Assert.assertEquals(12,custDetails.getAge());
	}

	public void testGetPhoneNumber() {
		
		
		Assert.assertEquals("1234567890", custDetails.getPhoneNumber());
		Assert.assertNotSame("kumar@", custDetails.getPhoneNumber());
	}

	public void testGetAadharNumber() {

		
		Assert.assertEquals("123456789012", custDetails.getAadharNumber());
		Assert.assertNotSame("123456566", custDetails.getAadharNumber());
	}

	public void testGetEmailID() {

		custDetails.setEmailID("aswani@capg.com");
		Assert.assertEquals("aswani@capg.com", custDetails.getEmailID());
		Assert.assertNotSame("aswani.com", custDetails.getEmailID());
	}

	}


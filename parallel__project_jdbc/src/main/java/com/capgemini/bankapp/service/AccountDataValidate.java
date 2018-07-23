package com.capgemini.bankapp.service;

public class AccountDataValidate {

public boolean validatePhoneNumber(Long phoneNumber) {
		
		if(phoneNumber.toString().length()==10) {
			return true;
		}
		else
			return false;
	}
	
	
	public boolean validateAadharNumber(Long aadharNumber) {
		
		
		if(aadharNumber.toString().length()==12) {
			return true;
		}
		else
		return false;
	}
	
}

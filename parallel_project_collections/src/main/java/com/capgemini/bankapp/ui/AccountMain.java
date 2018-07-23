package com.capgemini.bankapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.bankapp.bean.AccountDetails;
import com.capgemini.bankapp.bean.CustomerDetails;
import com.capgemini.bankapp.exception.AccountNotCreated;
import com.capgemini.bankapp.service.AccountDataValidate;
import com.capgemini.bankapp.service.AccountService;

public class AccountMain {

	public static void main(String[] args) {

		int i = 0;

		do {
			System.out.println("1.Login");
			System.out.println("2.Create Account");
			System.out.println("3.End Application");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			try {
				i = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (i) {

			case 1:
				login();
				break;

			case 2:
				createAccount();
				break;

			case 3:
				System.exit(0);
				break;
			}
		} while (i != 3);

	}

	private static void login() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		System.out.println("Enter account number : ");
		try {

			long accountNumber = Long.parseLong(br.readLine());
			System.out.println("Enter password : ");
			String password = br.readLine();
			AccountService service = new AccountService();
			if (service.testLogin(accountNumber, password)) {

				do {

					System.out.println("1.Show Balance");
					System.out.println("2.Deposit");
					System.out.println("3.WithDraw");
					System.out.println("4.Fund Transfer");
					System.out.println("5.Print Transaction");
					System.out.println("6.exit");

					try {
						i = Integer.parseInt(br.readLine());
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					switch (i) {

					case 1:
						System.out.println(service.showBalance());
						break;

					case 2:
						try {

							System.out.println("Enter the amount to deposit");
							double amount = Double.parseDouble(br.readLine());

							if (service.deposit(amount)) {
								System.out.println("The Amount is deposited in " + accountNumber);
							} else {
								System.out.println("The account doesnot exist");
							}

						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						break;

					case 3:
						try {

							System.out.println("Enter the amount to withdraw");
							double amount = Double.parseDouble(br.readLine());

							if(service.withdraw(amount)) {
								System.out.println("Withdraw Complete");
							}else {
								
									System.out.println("Amount is greater than available balance");
								
							}

						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						break;

					case 4:

						System.out.println("Enter payee account number");
						long payeeAccountNumber = Long.parseLong(br.readLine());
						System.out.println("Enter amount to transfer");
						double amount = Double.parseDouble(br.readLine());
						if (service.fundTransfer(payeeAccountNumber, amount))
							;
						break;

					case 5:
						service.printTransaction();

						break;

					case 6:

						break;
					}
				} while (i != 6);

			} else {
				System.out.println("Account not found");
			}

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	private static void createAccount() {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		AccountDetails account = new AccountDetails();
		CustomerDetails custDetails = new CustomerDetails();

		AccountDataValidate validate = new AccountDataValidate();
		
		
		
List<String> list2 = new ArrayList();
account.setpTrans(list2);

		System.out.println("Enter Full Name : ");
		String fullName;
		try {

			int count = 0;
			fullName = br.readLine();

			custDetails.setFullName(fullName);

			System.out.println("Enter Email ID : ");
			String emailID = br.readLine();
			custDetails.setEmailID(emailID);

			System.out.println("Enter Phone Number : ");

			do {
				try {
					Long phoneNumber = Long.parseLong(br.readLine());

					boolean isValidPhoneNumber = validate.validatePhoneNumber(phoneNumber);

					if (isValidPhoneNumber) {
						custDetails.setPhoneNumber(phoneNumber);
						count = 1;
					} else {
						System.out.println("Enter correct  Phone Number : ");
					}

				} catch (NumberFormatException e) {
					System.err.println("Enter correct  Phone Number : ");
				}

			} while (count < 1);

			System.out.println("Enter Aadhar Number : ");
			do {try {
				Long aadharNumber = Long.parseLong(br.readLine());
				boolean isValidAadharNumber = validate.validateAadharNumber(aadharNumber);
				if (isValidAadharNumber) {
					custDetails.setAadharNumber(aadharNumber);
					count = 2;
				} else {

					System.out.println("Enter correct  Aadhar Number : ");
				}
				}catch (NumberFormatException e){
					System.err.println("Enter correct  Aadhar Number : ");
				}
			} while (count < 2);

			System.out.println("Enter gender(Male/Female) : ");
			String gender = br.readLine();
			custDetails.setGender(gender);

			System.out.println("Enter age : ");
			int age = Integer.parseInt(br.readLine());
			custDetails.setAge(age);

			System.out.println("Enter amount :  ( Minimum amount to create account is 500.00)");
			double balance = Double.parseDouble(br.readLine());
			account.setBalance(balance);

			
		
			long accountNumber = (long) (Math.random() * 100000 + 9999);
			account.setAccountNumber(accountNumber);

			AccountService service = new AccountService();
			if (service.addAccountDetails(account)) {
				System.out.println("Account creation succesfull");
				System.out.println("Set up a password !");
				String password = br.readLine();
				account.setPassword(password);
				account.setCustomer(custDetails);

				System.out.println("Your account number is: " + accountNumber);

			} else {
				throw new AccountNotCreated();
				}
			}catch(AccountNotCreated e) {
				System.err.println("Failed to create account !!!!");
			}
 catch (IOException e) {
		
			e.printStackTrace();
		} catch (NumberFormatException e) {
		System.err.println("cannot enter alphabets");
		}

	}

	private static void exit() {
		System.out.println("Thankyou for using Application");
		System.exit(0);

	}
}

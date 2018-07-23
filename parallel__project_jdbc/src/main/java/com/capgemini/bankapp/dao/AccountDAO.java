package com.capgemini.bankapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.bankapp.bean.AccountDetails;

public class AccountDAO implements IAccountDAO {

	AccountDetails login = new AccountDetails();
	DBUtil util = new DBUtil();

	int n = 0, n1 = 0;
	static ResultSet rs1;

	public boolean addAccountDetails(AccountDetails account) throws SQLException {

		try {

			String insertQuery1 = "insert into account values(?,?,?,?,?)";
			PreparedStatement pstmt1 = util.getConnection().prepareStatement(insertQuery1);

			pstmt1.setLong(1, account.getAccountNumber());
			pstmt1.setString(2, account.getPassword());
			pstmt1.setDouble(3, account.getBalance());
			pstmt1.setDouble(4, account.getWithdraw());
			pstmt1.setDouble(5, account.getDeposit());
			n1 = pstmt1.executeUpdate();

			String insertQuery = "insert into customer values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = util.getConnection().prepareStatement(insertQuery);

			pstmt.setString(1, account.customer.getFullName());
			pstmt.setInt(2, account.customer.getAge());
			pstmt.setString(3, account.customer.getGender());
			pstmt.setLong(4, account.customer.getPhoneNumber());
			pstmt.setString(5, account.customer.getEmailID());
			pstmt.setLong(6, account.customer.getAadharNumber());
			pstmt.setLong(7, account.customer.getAccountNumber());
			n = pstmt.executeUpdate();

			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean testLogin(long accountNumber, String password) throws SQLException {

		try {

			String select = "select * from account";
			PreparedStatement pstmt = util.getConnection().prepareStatement(select);
			ResultSet s = pstmt.executeQuery();
			while (s.next()) {
				long acc = s.getLong("accountnumber");
				String pass = s.getString("password");
				if ((accountNumber == acc) && (password.equals(pass))) {
					login.setAccountNumber(accountNumber);

					return true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public double showBalance() throws SQLException {

		try {

			String select = "select balance from account where accountnumber=?";
			PreparedStatement pstmt = util.getConnection().prepareStatement(select);
			pstmt.setLong(1, login.getAccountNumber());
			ResultSet s1 = pstmt.executeQuery();
			if (s1.first()) {
				double result = s1.getDouble("balance");
				return result;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public boolean deposit(double amount) throws SQLException {

		try {
			double result = showBalance();

			double balance = result + amount;

			String select = "update  account set balance=? where accountnumber=?";

			PreparedStatement pstmt = util.getConnection().prepareStatement(select);
			pstmt.setDouble(1, balance);
			pstmt.setLong(2, login.getAccountNumber());

			pstmt.executeUpdate();

			String insert = "insert into transactions values(?,?,?)";

			PreparedStatement pstmt1 = util.getConnection().prepareStatement(insert);
			int transid = (int) (Math.random() * 10000 + 9999);
			String details = (" amount : " + amount + " is credited");
			pstmt1.setLong(1, login.getAccountNumber());
			pstmt1.setInt(2, transid);
			pstmt1.setString(3, details);
			pstmt1.executeUpdate();

			return true;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public boolean withdraw(double amount) throws SQLException {

		double result = showBalance();


		double balance = result - amount;

			

		String select = "update  account set balance=? where accountnumber=?";

		PreparedStatement pstmt;
		try {
			pstmt = util.getConnection().prepareStatement(select);

			pstmt.setDouble(1, balance);
			pstmt.setLong(2, login.getAccountNumber());

			pstmt.executeUpdate();

			String insert = "insert into transactions values(?,?,?)";

			PreparedStatement pstmt1 = util.getConnection().prepareStatement(insert);
			int transid = (int) (Math.random() * 10000 + 9999);
			String details = (" amount : " + amount + " is withdrawn/transfered");
			pstmt1.setLong(1, login.getAccountNumber());
			pstmt1.setInt(2, transid);
			pstmt1.setString(3, details);
			pstmt1.executeUpdate();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean printTransaction() throws ClassNotFoundException, SQLException {

		String select = "select * from transactions where accountnumber=?";
		PreparedStatement pstmt = util.getConnection().prepareStatement(select);

		pstmt.setLong(1, login.getAccountNumber());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			System.out.println(rs.getString(3));
		}
		return true;
	}

	public boolean fundTransfer(long payeeAccountNumber, double amount) throws SQLException {

		withdraw(amount);

		try {

			String select = "select balance from account where accountnumber=?";
			PreparedStatement pstmt = util.getConnection().prepareStatement(select);
			pstmt.setLong(1, payeeAccountNumber);
			ResultSet s1 = pstmt.executeQuery();
			if (s1.first()) {

				double result = s1.getDouble("balance");
				double balance = result + amount;
				String select1 = "update  account set balance=? where accountnumber=?";

				PreparedStatement pstmt1 = util.getConnection().prepareStatement(select1);
				pstmt1.setDouble(1, balance);
				pstmt1.setLong(2, payeeAccountNumber);

				pstmt1.executeUpdate();

				String insert = "insert into transactions values(?,?,?)";

				PreparedStatement pstmt2 = util.getConnection().prepareStatement(insert);
				int transid = (int) (Math.random() * 10000 + 9999);
				String details = ( amount + " is tranasfered from " + login.getAccountNumber());
				pstmt2.setLong(1, login.getAccountNumber());
				pstmt2.setInt(2, transid);
				pstmt2.setString(3, details);
				pstmt2.executeUpdate();

				return true;

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}
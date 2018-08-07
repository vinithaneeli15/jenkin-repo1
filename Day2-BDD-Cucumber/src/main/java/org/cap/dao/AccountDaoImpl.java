package org.cap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.cap.model.Account;




public class AccountDaoImpl implements IAccountDao{

	@Override
	public boolean addAccount(Account account){
		String sql="insert into account values(?,?,?)";
		try {
			Connection conn=getMySqlConnection();
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, account.getAccountNo());
			pst.setDouble(2, account.getOpeningBalance());
			pst.setString(3, account.getCustomer().getFirstName());
			int count=pst.executeUpdate();
			if(count>0)
		return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

private Connection getMySqlConnection() {
	Connection connection=null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd", "root", "India123");
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}		
			
	
	
	return connection;
	

}

@Override
public Account findAccountById(int accountNo) {
	/*String sql="select * from account where accountNo=?";
	//ResultSet account = null;
	try {
		System.out.println("Hiiiiiiiiiiiiiiii");
		Connection conn=getMySqlConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, accountNo);
		Account account = (Account) pst.executeQuery(sql);
		System.out.println("Hiiiiiiiiiiiiiiii");
		System.out.println(account);
		return (Account) account;
			
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	*/
	return null;
}

@Override
public Account updateAccount(int accountNo, double amount) {
	// TODO Auto-generated method stub
	return null;
}

}

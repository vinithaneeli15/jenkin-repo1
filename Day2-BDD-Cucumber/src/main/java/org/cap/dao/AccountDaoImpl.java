package org.cap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.cap.model.Account;



public class AccountDaoImpl implements AccountDao {

	@Override
	public boolean addAccount(Account account) {
		String sql="insert into Account values(?,?,?)";
		try {
			Connection conn=getMySqlConnection();
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, account.getAccountNo());
			pst.setDouble(2,account.getOpeningBalance());
			pst.setString(3, account.getCustomer().getFirstName());
			int count=pst.executeUpdate();
			if(count>0)
				return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	private Connection getMySqlConnection() throws SQLException {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd", "root","India123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}


}

package org.cap.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

public class AccountUtil {
private static int accountNo=0;
public static int generateAccountNo() {
	return ++accountNo;
}
private static Connection connAccount;

public static Connection createConnection() throws ClassNotFoundException,
		SQLException {
	
	String url = "jdbc:mysql://localhost:3306/capflp";
	String username = "root";
	String password ="India123";
	String driver = "com.mysql.jdbc.Driver";

	Class.forName(driver);

	connAccount = (Connection) DriverManager.getConnection(url, username, password);

	return connAccount;
}

public static void closeConnection() throws SQLException {
	connAccount.close();
}
}

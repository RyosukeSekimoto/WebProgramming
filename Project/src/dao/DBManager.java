package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	private static String url =  "jdbc:mysql://localhost/WebProgramming";//データベース'Webprogramming'
	private static String user = "root";
	private static String pass = "password";

	//DBを接続するコネクションを返す

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}
}

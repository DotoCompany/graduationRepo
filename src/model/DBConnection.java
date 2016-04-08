package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DBConnection {
	private Connection conn;
	public static final DBConnection dbConnection;
	static {
		dbConnection = new DBConnection();
	}
	public Connection getConn() {
		return conn;
	}
	public static DBConnection getInstance() {
		return dbConnection;
	}
	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://172.31.132.183:3306/graduationRepo","root","0000");
			conn.setAutoCommit(false);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String [] args) {
		DBConnection.getInstance();
	}
}
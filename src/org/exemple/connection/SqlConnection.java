package org.exemple.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/jee";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PWD = "root";
	private Connection conn = null;
	
	private SqlConnection(){
		
		
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PWD);
			

		}
		catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}
	
	static private final SqlConnection instance = new SqlConnection();
	
	static public SqlConnection getInstance() {
		return instance;
	}

	public Connection getConnection() {
		return conn;
	}
}

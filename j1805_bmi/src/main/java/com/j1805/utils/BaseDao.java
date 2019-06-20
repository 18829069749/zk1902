package com.j1805.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	static String driver = Env.newInstance().getProperty("driver");// "oracle.jdbc.OracleDriver";

	static String url = Env.newInstance().getProperty("url");//"jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	static String user =  Env.newInstance().getProperty("username");
	static String pwd =  Env.newInstance().getProperty("pwd");

	protected Connection conn = null;
	protected  ResultSet rs = null;
	protected Statement stmt = null;

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	 public void getConnection(){
	    	try {
				conn = DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	 public void closeAll() {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
}

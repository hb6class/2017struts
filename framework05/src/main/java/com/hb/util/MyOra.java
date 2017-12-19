package com.hb.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyOra {
	private static Connection conn;
	private static String driver="oracle.jdbc.OracleDriver";
	private static String url="jdbc:oracle:thin:@203.236.209.193:1521:xe";
	private static String username="scott";
	private static String password="tiger";
	
	private MyOra() {
	}
	
	public static Connection getConnection() throws Exception{
		if(conn==null || conn.isClosed()){
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
		}
		return conn;
	}
	
}

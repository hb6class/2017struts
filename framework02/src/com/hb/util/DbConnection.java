package com.hb.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static Connection conn;

	private DbConnection() {
	}
	
	public static Connection getConnection() throws Exception{
		if(conn==null || conn.isClosed()){
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@203.236.209.193:1521:xe"
					, "scott", "tiger");
		}
		return conn;
	}
}

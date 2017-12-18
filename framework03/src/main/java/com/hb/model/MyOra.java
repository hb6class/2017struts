package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyOra {
	private static Connection conn;
	private static String url="jdbc:oracle:thin:@203.236.209.193:1521:xe";
	private static String user="scott";
	private static String password="tiger";
	private MyOra() {
	}
	public static Connection getConnection() throws Exception{
		if(conn==null || conn.isClosed()){
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection(url, user, password);
		}
		return conn;
	}
}

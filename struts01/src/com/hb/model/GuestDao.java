package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hb.model.entity.GuestVo;
/*
jdbc:mysql://[host][,failoverhost...][:port]/database]

url : jdbc:mysql://localhost:3306/xe
id : scott
pw : tiger

ORACLE
	DRIVER - oracle.jdbc.driver.OracleDriver
	URL - jdbc:oracle:thin:@hostname:port:SID

MSSQL
	DRIVER - com.microsoft.jdbc.sqlserver.SQLServerDriver
	URL - jdbc:Microsoft:sqlserver://localhost:1433;databasename=DB¸í

MYSQL
	DRIVER - org.gjt.mm.mysql.Driver
	URL - jdbc:mysql://localhost:3306/DB¸í
*/
public class GuestDao {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/xe";
	private String user="scott";
	private String password="tiger";

	public List<GuestVo> selectAll() throws Exception{
		List<GuestVo> list = new ArrayList<GuestVo>();
		Class.forName(driver);
		try(Connection conn=
				DriverManager.getConnection(url, user, password);
				){
			PreparedStatement pstmt =
					conn.prepareStatement("select * from guest01");
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) {
				GuestVo bean = new GuestVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				list.add(bean);
			}
		}
		return list;
	}

	public void addOne(String name, int pay) throws Exception {
		String sql="insert into guest01 (name,nalja,pay) ";
		sql+="values (?,now(),?)";
		Class.forName(driver);
		try(
				Connection conn=DriverManager.getConnection(
						url, user, password);
				){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, pay);
			pstmt.executeUpdate();
		}
	}

	public GuestVo selectOne(int sabun) throws Exception {
		String sql="select * from guest01 where sabun=?";
		GuestVo bean = new GuestVo();
		Class.forName(driver);
		try(
				Connection conn=DriverManager.getConnection(
						url, user, password);
				){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
			}
		}
		return bean;
	}
}


















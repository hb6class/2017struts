package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.model.entity.GuestVo;

public class GuestDaoImpl implements GuestDao<GuestVo>{
	String driver;
	String url;
	String user;
	String password;
	
		
	public GuestDaoImpl(String driver, String url, String user, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}


	public List<GuestVo> selectAll() throws SQLException, ClassNotFoundException{
		String sql="select * from guest02";
		List<GuestVo> list = new ArrayList<GuestVo>();
		Class.forName(driver);
		try(
		Connection conn=DriverManager.getConnection(url, user, password);
		){
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				GuestVo bean = new GuestVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getTimestamp("nalja"));
				bean.setPay(rs.getInt("pay"));
				list.add(bean);
			}
		}
		return list;
	}


	public void addOne(GuestVo bean) throws SQLException, ClassNotFoundException {
		String sql="insert into guest02 (name,nalja,pay) values (?,now(),?)";
		Class.forName(driver);
		try(
			Connection conn=DriverManager.getConnection(url, user, password);
				){
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.executeUpdate();
		}
	}


	@Override
	public GuestVo selectOne(int su) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int editOne(GuestVo bean) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int delOne(int su) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}
}












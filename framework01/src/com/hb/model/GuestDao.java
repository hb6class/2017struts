package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.model.entity.GuestDto;

public class GuestDao {
	String driver ="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@203.236.209.193:1521:xe";
	String id="scott";
	String pw="tiger";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public GuestDao() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, id, pw);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<GuestDto> selectAll(){
		String sql="SELECT * FROM GUEST01";
		List<GuestDto> list = executeQuery(sql,new Object[]{});
		return list;
	}

	public GuestDto selectOne(int sabun) {
		String sql="select * from guest01 where sabun=?";
		List<GuestDto> list = executeQuery(sql, new Object[]{sabun});
		return list.get(0);
	}
	
	public void insertOne(int sabun, String name, String nalja, int pay) {
		String sql="INSERT INTO GUEST01 (SABUN,NAME,NALJA,PAY) ";
		sql+=" VALUES (?,?,TO_DATE(?,'YYYY-MM-DD'),?)";
		Object[] objs={sabun,name,nalja,pay};
		executeUpdate(sql,objs);
	}

	public void updateOne(int sabun, String name, int pay) {
		String sql="UPDATE GUEST01 SET NAME=?,PAY=? WHERE SABUN=?";
		executeUpdate(sql, new Object[]{name,pay,sabun});
		
	}
	
	public void deleteOne(int sabun){
		String sql = "DELETE FROM GUEST01 WHERE SABUN=?";
		executeUpdate(sql, new Object[]{sabun});
	}
	
	private List executeQuery(String sql,Object[] objs){
		List<GuestDto> list = new ArrayList<GuestDto>();
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++)pstmt.setObject(i+1, objs[i]);
			rs=pstmt.executeQuery();
			while(rs.next()){
				GuestDto bean= new GuestDto();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			allClose();
		}
		
		return list;
	}
	
	private void executeUpdate(String sql,Object[] objs){
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<objs.length ;i++){
			pstmt.setObject(i+1, objs[i]);
			}
			pstmt.executeUpdate();
		}catch(Exception e){
		}finally{
			allClose();
		}
	}
	
	private void allClose(){
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}















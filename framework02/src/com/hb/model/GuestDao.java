package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.core.JdbcUpdate;
import com.hb.model.entity.GuestVo;

public class GuestDao {
//템플릿 메소드 패턴(Template Method Pattern)

	public List<GuestVo> selectAll() throws Exception {
		String sql="select * from guest01";
		List<GuestVo> list = new ArrayList<GuestVo>();
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@203.236.209.193:1521:xe"
				, "scott", "tiger");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			list.add(new GuestVo(rs.getInt("sabun")
					,rs.getString("name")
					,rs.getDate("nalja")
					,rs.getInt("pay")));
		}
		}finally{
			if(conn!=null)conn.close();
		}
		return list;
	}
	
	public GuestVo selectOne(int sabun) throws Exception {
		String sql="select * from guest01 where sabun=?";
		GuestVo bean=new GuestVo();
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@203.236.209.193:1521:xe"
				, "scott", "tiger");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sabun);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			bean.setSabun(rs.getInt("sabun"));
			bean.setName(rs.getString("name"));
			bean.setNalja(rs.getDate("nalja"));
			bean.setPay(rs.getInt("pay"));
		}
		}finally{
			if(conn!=null)conn.close();
		}
		return bean;
	}

	public void addOne(GuestVo bean) throws Exception {
		JdbcUpdate jdbc=new JdbcUpdate(){

			@Override
			public void setPstmt(PreparedStatement pstmt) throws SQLException{
				pstmt.setInt(1, bean.getSabun());
				pstmt.setString(2, bean.getName());
				pstmt.setInt(3, bean.getPay());		
			}
			
		};
		jdbc.executeUpdate("insert into guest01 values (?,?,sysdate,?)");
	}

	public void editOne(GuestVo bean) throws Exception{
		String sql="update guest01 set name=?,pay=? where sabun=?";
		JdbcUpdate jdbc = new JdbcUpdate() {
			
			@Override
			public void setPstmt(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bean.getName());
				pstmt.setInt(2, bean.getPay());
				pstmt.setInt(3, bean.getSabun());
			}
		};
		jdbc.executeUpdate(sql);
	}


}









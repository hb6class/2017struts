package com.hb.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.util.DbConnection;

public abstract class JdbcTemplate<T> {
	
	public void executeUpdate(String sql) throws Exception{
		Object[] objs={};
		executeUpdate(sql,objs);
	}
	public void executeUpdate(String sql, Object[] objs) throws Exception{
		Connection conn = null;
		try{
		conn=DbConnection.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		pstmt.executeUpdate();
		}finally{
			if(conn!=null)conn.close();
		}
	}
	
	public T executeOne(String sql,Object[] objs) throws Exception{
		List<T> list = executeQuery(sql,objs);
		return list.get(0);
	}
	
	public List<T> executeQuery(String sql) throws Exception {
		Object[] objs={};
		return executeQuery(sql,objs);
	}
	
	public List<T> executeQuery(String sql,Object[] objs) throws Exception {
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		try{
		conn = DbConnection.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			list.add(rowMapper(rs));
		}
		}finally{
			if(conn!=null)conn.close();
		}
		return list;
	}
	
	public abstract T rowMapper(ResultSet rs) throws SQLException;
}

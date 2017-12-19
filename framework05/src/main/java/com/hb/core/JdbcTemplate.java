package com.hb.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hb.util.MyOra;

public class JdbcTemplate<T> {
	
	public T executeOne(String sql,RowMapper<T> mapper,Object ...objs) throws Exception{
		return executeQuery(sql,mapper,objs).get(0);
	}
	public List<T> executeQuery(String sql,RowMapper<T> mapper,Object ... objs) throws Exception{
		Connection conn =null;
		List<T> list = new ArrayList<T>();
		try{
		conn = MyOra.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			list.add(mapper.mapRow(rs));
		}
		}finally{
			if(conn!=null)conn.close();
		}
		return list;
	}
	
	public int executeUpdate(String sql,Object ... objs) throws Exception{
		Connection conn =null;
		List<T> list = new ArrayList<T>();
		try{
		conn = MyOra.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		return pstmt.executeUpdate();
		}finally{
			if(conn!=null)conn.close();
		}
	}
}

package com.hb.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.model.MyOra;
import com.hb.model.entity.GuestVo;

public class JdbcTemplate {
	
	public Object executeOne(String sql,Object[] objs,RowMapper mapper) throws Exception{
		return executeQuery(sql,objs,mapper).get(0);
	}
	public List executeQuery(String sql,RowMapper mapper) throws Exception{
		return executeQuery(sql,new Object[]{},mapper);
	}
	public List executeQuery(String sql,Object[] objs,RowMapper mapper) throws Exception{
		Connection conn =null;
		List list = new ArrayList();
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
	
	public int executeUpdate(String sql,Object[] objs) throws Exception{
		Connection conn =null;
		List<GuestVo> list = new ArrayList<GuestVo>();
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

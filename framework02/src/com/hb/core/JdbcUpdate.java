package com.hb.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hb.util.DbConnection;

public abstract class JdbcUpdate {

	public void executeUpdate(String sql) throws Exception{
		Connection conn = null;
		try{
		conn=DbConnection.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		setPstmt(pstmt);
		pstmt.executeUpdate();
		}finally{
			if(conn!=null)conn.close();
		}
	}
	
	public abstract void setPstmt(PreparedStatement pstmt) throws SQLException;
}

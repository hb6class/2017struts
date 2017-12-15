package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hb.model.entity.GuestVo;

public class GuestDao {
//템플릿 메소드 패턴(Template Method Pattern)

	public List<GuestVo> selectAll() throws Exception {
		String sql="select * from guest01";
		List<GuestVo> list = new ArrayList<GuestVo>();
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(
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
		
		return list;
	}

}









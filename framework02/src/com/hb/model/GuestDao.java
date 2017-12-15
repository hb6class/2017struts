package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import com.hb.core.JdbcQuery;
import com.hb.core.JdbcTemplate;
import com.hb.core.JdbcUpdate;
import com.hb.model.entity.GuestVo;
import com.hb.util.DbConnection;

public class GuestDao {
//템플릿 메소드 패턴(Template Method Pattern)

	public List<GuestVo> selectAll() throws Exception {
		String sql="select * from guest01";
		JdbcTemplate<GuestVo> jdbc = new JdbcTemplate<GuestVo>(){
						
			@Override
			public GuestVo rowMapper(ResultSet rs) throws SQLException {
				GuestVo bean = new GuestVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				return bean;
			}
		};
		List<GuestVo> list =jdbc.executeQuery(sql);
		return list;
	}
	
	
	
	public GuestVo selectOne(int sabun) throws Exception {

		Object[] objs={sabun};
		JdbcTemplate<GuestVo> jdbc = new JdbcTemplate<GuestVo>() {
			
			@Override
			public GuestVo rowMapper(ResultSet rs) throws SQLException {
				GuestVo bean=new GuestVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				return bean;
			}
		};
		GuestVo bean = jdbc.executeOne("select * from guest01 where sabun=?",objs);
		return bean;
	}




	public void addOne(GuestVo bean) throws Exception {
		JdbcTemplate<GuestVo> jdbc=new JdbcTemplate<GuestVo>(){

			@Override
			public GuestVo rowMapper(ResultSet rs) throws SQLException {
				return null;
			}
		
		};
		jdbc.executeUpdate("insert into guest01 values (?,?,sysdate,?)", new Object[]{bean.getSabun(),bean.getName(),bean.getPay()});
	}

	public void editOne(GuestVo bean) throws Exception{
		String sql="update guest01 set name=?,pay=? where sabun=?";
		JdbcTemplate<GuestVo> jdbc = new JdbcTemplate<GuestVo>() {

			@Override
			public GuestVo rowMapper(ResultSet rs) throws SQLException {
				return null;
			}
		};
		jdbc.executeUpdate(sql, new Object[]{bean.getName(),bean.getPay(),bean.getSabun()});
	}


}









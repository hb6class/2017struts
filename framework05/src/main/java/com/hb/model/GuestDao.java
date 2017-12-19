package com.hb.model;

import java.sql.ResultSet;
import java.util.List;

import org.apache.naming.java.javaURLContextFactory;

import com.hb.core.JdbcTemplate;
import com.hb.core.RowMapper;
import com.hb.model.entity.GuestVo;

public class GuestDao {
	private JdbcTemplate<GuestVo> template;
	private RowMapper<GuestVo> mapper= new RowMapper<GuestVo>() {
		
		@Override
		public GuestVo mapRow(ResultSet rs) throws Exception {
			GuestVo bean = new GuestVo();
			bean.setSabun(rs.getInt("sabun"));
			bean.setName(rs.getString("name"));
			bean.setNalja(rs.getDate("nalja"));
			bean.setPay(rs.getInt("pay"));
			return bean;
		}
	};
	
	public void insertOne(GuestVo bean) throws Exception{
		template = new JdbcTemplate<GuestVo>();
		template.executeUpdate("insert into guest01 values (?,?,sysdate,?)"
				, bean.getSabun(),bean.getName(),bean.getPay());
	}	
	
	public int deleteOne(int sabun) throws Exception{
		template = new JdbcTemplate<GuestVo>();
		return template.executeUpdate("delete from guest01 where sabun=?"
				, sabun);
	}
	
	public GuestVo selectOne(int sabun) throws Exception{
		template = new JdbcTemplate<GuestVo>();
		return template.executeOne("select * from guest01 where sabun=?"
				, mapper, sabun);
	}
	
	public int editOne(GuestVo bean) throws Exception{
		template = new JdbcTemplate<GuestVo>();
		return template.executeUpdate("update guest01 set name=?,pay=? where sabun=?"
				, bean.getName(),bean.getPay(),bean.getSabun());
	}
	
	public List<GuestVo> selectAll() throws Exception{
		template = new JdbcTemplate<GuestVo>();
		return template.executeQuery("select * from guest01", mapper);
	}
	
}


















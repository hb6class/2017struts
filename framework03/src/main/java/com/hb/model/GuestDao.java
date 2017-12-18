package com.hb.model;

import java.sql.ResultSet;
import java.util.List;

import com.hb.core.JdbcTemplate;
import com.hb.core.RowMapper;
import com.hb.model.entity.GuestVo;

public class GuestDao {
	RowMapper<GuestVo> mapper = new RowMapper<GuestVo>() {
		
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

	public GuestVo selectOne(int sabun)throws Exception{
		String sql="select * from guest01 where sabun=?";
		JdbcTemplate<GuestVo> template=new JdbcTemplate<GuestVo>();
		return template.executeOne(sql, mapper, sabun);
	}
	
	public List<GuestVo> selectAll() throws Exception {
		String sql ="select * from guest01";
		JdbcTemplate<GuestVo> template = new JdbcTemplate<GuestVo>();
		return template.executeQuery(sql, mapper);
	}

	public int insertOne(final GuestVo bean) throws Exception {
		String sql ="insert into guest01 values (?,?,sysdate,?)";
		JdbcTemplate<GuestVo> template = new JdbcTemplate<GuestVo>();
		return template.executeUpdate(sql,bean.getSabun(),bean.getName(),bean.getPay());
	}
	
	public int deleteOne(int sabun) throws Exception{
		String sql ="delete from guest01 where sabun=?";
		JdbcTemplate<GuestVo> template = new JdbcTemplate<GuestVo>();
		return template.executeUpdate(sql, sabun);
	}

}

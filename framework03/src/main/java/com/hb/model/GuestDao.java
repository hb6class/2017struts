package com.hb.model;

import java.sql.ResultSet;
import java.util.List;

import com.hb.core.JdbcTemplate;
import com.hb.core.RowMapper;
import com.hb.model.entity.GuestVo;

public class GuestDao {
	
	public List<GuestVo> selectAll() throws Exception {
		String sql ="select * from guest01";
		JdbcTemplate template = new JdbcTemplate();
		RowMapper mapper = new RowMapper(){

			@Override
			public Object mapRow(ResultSet rs) throws Exception {
				GuestVo bean = new GuestVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				return bean;
			}
			
		};
		return template.executeQuery(sql, mapper);
	}

	public int insertOne(final GuestVo bean) throws Exception {
		String sql ="insert into guest01 values (?,?,sysdate,?)";
		JdbcTemplate template = new JdbcTemplate();
		return template.executeUpdate(sql,new Object[]{bean.getSabun(),bean.getName(),bean.getPay()});
	}
	

}

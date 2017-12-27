package com.hb.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hb.model.entity.GuestVo;

public class GuestDaoImpl implements GuestDao {
	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	RowMapper rowMapper=new RowMapper(){
				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new GuestVo(
							rs.getInt("sabun")
							, rs.getString("name")
							, rs.getTimestamp("nalja")
							, rs.getInt("pay"));
				}
		};

	@Override
	public List<GuestVo> selectAll() throws Exception {
		String sql="SELECT * FROM GUEST03";
//		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return (List<GuestVo>)jdbcTemplate.query(sql,rowMapper);
	}

	@Override
	public GuestVo selectOne(int sabun) throws Exception {
		String sql="select * from guest03 where sabun=?";
		return (GuestVo)jdbcTemplate.queryForObject(sql
				,new Object[]{sabun}, rowMapper);
//////////////////////////
		//		return ((List<GuestVo>)jdbcTemplate.query(sql
//				,new Object[]{sabun},rowMapper)).get(0);
//////////////////////////		
//		ResultSetExtractor rse=new ResultSetExtractor<GuestVo>() {
//
//			@Override
//			public GuestVo extractData(ResultSet rs) throws SQLException,
//					DataAccessException {
//				if(rs.next()){
//				return new GuestVo(rs.getInt("sabun")
//						, rs.getString("name")
//						, rs.getTimestamp("nalja")
//						, rs.getInt("pay"));
//				}else{
//					return null;
//				}
//			}
//
//		};
//		GuestVo bean = jdbcTemplate.query(sql
//							,new Object[]{sabun}, rse);
//		return bean;
	}

	@Override
	public void insertOne(GuestVo bean) throws Exception {
		String sql="insert into guest03 values (?,?,now(),?)";
		jdbcTemplate.update(sql, bean.getSabun()
							,bean.getName(),bean.getPay());
	}

	@Override
	public int deleteOne(int sabun) throws Exception {
		String sql="delete from guest03 where sabun=?";
		return jdbcTemplate.update(sql, sabun);
	}

	@Override
	public int updateOne(GuestVo bean) throws Exception {
		String sql="update guest03 set name=?,pay=? where sabun=?";
		return jdbcTemplate.update(sql
				, bean.getName(),bean.getPay(),bean.getSabun());
	}
	
	

}

package com.hb.model;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.hb.model.entity.GuestVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class GuestDao2Impl extends SqlMapClientDaoSupport implements GuestDao {
	SqlMapClientTemplate template = getSqlMapClientTemplate();

	@Override
	public List<GuestVo> selectAll() throws Exception {
		return template.queryForList("selectAll");
	}

	@Override
	public GuestVo selectOne(int sabun) throws Exception {
		// TODO Auto-generated method stub
		return (GuestVo)template.queryForObject("selectOne", sabun);
	}

	@Override
	public void insertOne(GuestVo bean) throws Exception {
		template.insert("insertOne",bean);
	}

	@Override
	public int deleteOne(int sabun) throws Exception {
		return template.delete("deleteOne", sabun);
	}

	@Override
	public int updateOne(GuestVo bean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}

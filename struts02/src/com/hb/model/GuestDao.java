package com.hb.model;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.hb.model.entity.GuestVo;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class GuestDao {
	private static SqlMapClient smc;
	
	static{
		String path="./SqlMapConfig.xml";
		try {
			System.out.println("run");
			Reader reader = Resources.getResourceAsReader(path);
			smc=SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public List<GuestVo> selectAll() throws SQLException{
		List<GuestVo> list = (List<GuestVo>)smc.queryForList("selectAll");		
		return list;
	}


	public void insertOne(GuestVo bean) throws SQLException {
		smc.insert("insertOne",bean);
	}
}

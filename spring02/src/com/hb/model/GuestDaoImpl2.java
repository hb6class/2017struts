package com.hb.model;

import java.sql.SQLException;
import java.util.List;

import com.hb.model.entity.GuestVo;

public class GuestDaoImpl2 implements GuestDao<GuestVo> {

	@Override
	public List<GuestVo> selectAll() throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOne(GuestVo bean) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GuestVo selectOne(int su) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editOne(GuestVo bean) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delOne(int su) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}

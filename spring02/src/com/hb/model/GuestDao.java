package com.hb.model;

import java.sql.SQLException;
import java.util.List;

import com.hb.model.entity.GuestVo;

public interface GuestDao<T> {

	List<T> selectAll() throws SQLException, ClassNotFoundException;
	void addOne(T bean) throws SQLException, ClassNotFoundException;
	GuestVo selectOne(int su) throws SQLException, ClassNotFoundException;
	int editOne(T bean) throws SQLException, ClassNotFoundException;
	int delOne(int su) throws SQLException, ClassNotFoundException;
}

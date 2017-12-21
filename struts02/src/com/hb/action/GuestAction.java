package com.hb.action;

import java.sql.SQLException;
import java.util.List;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;

public class GuestAction{
	private List<GuestVo> list;
	public List<GuestVo> getList() {
		return list;
	}

	// POJO СіЧт(2.x)
	
	public String addForm(){
		return "success";
	}
	
	public String execute() throws SQLException {
		GuestDao dao = new GuestDao();
		list=dao.selectAll();		
		return "success";
	}

}

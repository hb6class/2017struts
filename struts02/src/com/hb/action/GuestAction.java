package com.hb.action;

import java.sql.SQLException;
import java.util.List;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class GuestAction implements Preparable,ModelDriven<GuestVo>{
	private GuestVo bean;
	private List<GuestVo> list;
	public List<GuestVo> getList() {
		return list;
	}

	// POJO СіЧт(2.x)
	
	public String insertOne() throws SQLException {
		GuestDao dao = new GuestDao();
		dao.insertOne(bean);
		return "success";
	}
	
	@Override
	public GuestVo getModel() {
		return bean;
	}
	
	@Override
	public void prepare() throws Exception {
		bean=new GuestVo();
	}
	
	public String addForm(){
		return "success";
	}
	
	public String execute() throws SQLException {
		GuestDao dao = new GuestDao();
		list=dao.selectAll();		
		return "success";
	}


}

package com.hb.action;

import java.util.List;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {

	private List<GuestVo> list;
	
	public List<GuestVo> getList() {
		return list;
	}

	@Override
	public String execute() throws Exception {
		GuestDao dao = new GuestDao();
		list=dao.selectAll();
		
		return SUCCESS;
	}

}

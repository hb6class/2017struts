package com.hb.action;

import java.sql.Date;

import com.hb.model.entity.GuestVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EditAction implements Action, ModelDriven<GuestVo>,Preparable {
	//sabun,name,pay
	private GuestVo bean;
	
	public GuestVo getBean() {
		return bean;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(">>> "+bean);
		return SUCCESS;
	}

	@Override
	public GuestVo getModel() {
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean=new GuestVo();
		bean.setNalja(new Date(System.currentTimeMillis()));
	}

}

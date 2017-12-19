package com.hb.action;

import com.opensymphony.xwork2.Action;

public class Test04Action implements Action{
	String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}

	@Override
	public String execute() throws Exception {
		
		System.out.println(msg);
		return SUCCESS;
	}

}

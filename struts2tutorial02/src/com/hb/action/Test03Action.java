package com.hb.action;

import com.opensymphony.xwork2.Action;

public class Test03Action implements Action {
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	@Override
	public String execute() throws Exception {
		msg="½ºÆ®·µÃ÷·Î Ãâ·Â";
		
		return SUCCESS;
	}

}

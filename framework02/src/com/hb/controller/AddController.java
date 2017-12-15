package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.core.MyController;

public class AddController implements MyController {

	@Override
	public String execute(HttpServletRequest req) {
		
		return "add";
	}

}

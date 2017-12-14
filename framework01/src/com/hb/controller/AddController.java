package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.core.Controller;

public class AddController implements Controller {
	// url -> add.do
	public String execute(HttpServletRequest req){
		System.out.println("AddController run...");
		// model
		return "add";
	}

}

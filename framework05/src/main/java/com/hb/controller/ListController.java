package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.core.MyController;
import com.hb.model.GuestDao;

public class ListController implements MyController {

	@Override
	public String execute(HttpServletRequest req) {
		GuestDao dao = new GuestDao();
		try {
			req.setAttribute("list", dao.selectAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

}

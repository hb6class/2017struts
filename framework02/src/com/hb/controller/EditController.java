package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.core.MyController;
import com.hb.model.GuestDao;

public class EditController implements MyController {

	@Override
	public String execute(HttpServletRequest req) {
		req.setAttribute("kor", "¼öÁ¤");
		req.setAttribute("eng", "Edit");
		GuestDao dao = new GuestDao();
		String idx=req.getParameter("idx");
		int sabun=Integer.parseInt(idx);
		try {
			req.setAttribute("bean", dao.selectOne(sabun));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "detail";
	}

}

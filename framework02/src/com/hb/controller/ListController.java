package com.hb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hb.core.MyController;
import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;

public class ListController implements MyController {

	@Override
	public String execute(HttpServletRequest req) {
		GuestDao dao = new GuestDao();
		List<GuestVo> list=null;
		try {
			list = dao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("alist", list);
		return "list";
	}

}

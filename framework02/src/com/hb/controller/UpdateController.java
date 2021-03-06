package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.core.MyController;
import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;

public class UpdateController implements MyController{

	@Override
	public String execute(HttpServletRequest req) {
		GuestDao dao = new GuestDao();
		
		GuestVo bean = new GuestVo();
		bean.setSabun(Integer.parseInt(req.getParameter("sabun")));
		bean.setName(req.getParameter("name"));
		bean.setPay(Integer.parseInt(req.getParameter("pay")));
		try {
			dao.editOne(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:detail.do?idx="+bean.getSabun();
	}

}

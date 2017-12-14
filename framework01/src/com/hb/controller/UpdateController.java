package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.core.Controller;
import com.hb.model.GuestDao;

public class UpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest req) {
		String param1=req.getParameter("sabun");
		String param2=req.getParameter("name");
		String param3=req.getParameter("pay");
		int sabun=Integer.parseInt(param1);
		String name=param2;
		int pay=Integer.parseInt(param3);
		GuestDao dao=new GuestDao();
		dao.updateOne(sabun,name,pay);
		System.out.println("UpdateController~~~~~~~");
		return "redirect:detail.do?idx="+sabun;
	}

}

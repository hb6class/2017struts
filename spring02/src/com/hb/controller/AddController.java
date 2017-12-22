package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;

public class AddController implements Controller {
	GuestDao dao;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse arg1) throws Exception {
		String name=req.getParameter("name");
		int pay=Integer.parseInt(req.getParameter("pay"));
		GuestVo bean = new GuestVo();
		bean.setName(name);
		bean.setPay(pay);
		dao.addOne(bean);
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		return mav;
	}

}










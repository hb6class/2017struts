package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.model.GuestDao;

public class ListController implements Controller {
	GuestDao dao;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.addObject("list", dao.selectAll());
		mav.setViewName("list");
		return mav;
	}

}










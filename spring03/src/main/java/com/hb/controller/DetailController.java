package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hb.model.GuestDao;

public class DetailController extends AbstractController {
	GuestDao dao;
	String viewName;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int sabun=Integer.parseInt(request.getParameter("sabun"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("bean", dao.selectOne(sabun));
		mav.setViewName(viewName);
		return mav;
	}

}

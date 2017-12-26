package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;

public class InsertController extends AbstractController {
	GuestDao dao;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		GuestVo bean = new GuestVo();
		bean.setName(request.getParameter("name"));
		bean.setPay(Integer.parseInt(request.getParameter("pay")));
		dao.insertOne(bean);
		mav.setViewName("redirect://list.do");
		return mav;
	}

}















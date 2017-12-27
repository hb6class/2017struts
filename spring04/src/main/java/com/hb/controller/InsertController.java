package com.hb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;

public class InsertController extends AbstractCommandController {
	GuestDao guestDao;
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}
	
	@Override
	protected void onBindAndValidate(HttpServletRequest request,
			Object command, BindException errors) throws Exception {
		String name=request.getParameter("name").trim();
		if(name.equals(""))
			errors.addError(new ObjectError("name", "ºóÄ­ºÒ°¡"));
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		GuestVo bean=(GuestVo) command;
		if(errors.hasErrors())
			return new ModelAndView("add","bean",bean);
		guestDao.insertOne(bean);
		return new ModelAndView("redirect:/list.do");
	}

}

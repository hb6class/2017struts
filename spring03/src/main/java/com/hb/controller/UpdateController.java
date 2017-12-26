package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;

public class UpdateController extends AbstractCommandController {
	GuestDao dao;
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}

	@Override
	protected void onBindAndValidate(HttpServletRequest request,
			Object command, BindException errors) throws Exception {
		System.out.println("onBindAndValidate()");
		if("".equals(request.getParameter("name"))){			
			ObjectError error=new ObjectError("name", "ºñ¾úÀ½");
			errors.addError(error);
		}
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		GuestVo bean = (GuestVo) command;
		dao.updateOne(bean);
		if(errors.hasErrors())return new ModelAndView("redirect://edit.do?sabun="+bean.getSabun());
		return new ModelAndView("redirect://list.do");
	}

}

package com.hb.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hb.core.Controller;
import com.hb.model.GuestDao;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest req) {
		Map<String, String> param=new HashMap<String, String>();
		
		Enumeration<String> paramNames = req.getParameterNames();
		while(paramNames.hasMoreElements()){
			String pname=paramNames.nextElement();
			param.put(pname, req.getParameter(pname));
		}
		
		int sabun=Integer.parseInt(param.get("sabun"));
		String name=param.get("name");
		String nalja=param.get("nalja");
		int pay=Integer.parseInt(param.get("pay"));
		
		GuestDao dao = new GuestDao();
		dao.insertOne(sabun,name,nalja,pay);
		return "redirect:list.do";
	}

}

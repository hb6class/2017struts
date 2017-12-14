package com.hb.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.AddController;
import com.hb.controller.DetailController;
import com.hb.controller.InsertController;
import com.hb.controller.ListController;
import com.hb.controller.UpdateController;

public class FrontController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("post ~~~~~~~~~~~~~~~~");
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uri=req.getRequestURI();
		String cpath=req.getContextPath();
		String url=uri.substring(cpath.length());
		System.out.println(url);
		Controller controll=null;
		if("/list.do".equals(url)){
			controll=new ListController();
		}else if("/add.do".equals(url)){
			controll=new AddController();
		}else if("/insert.do".equals(url)){
			controll=new InsertController();
		}else if("/detail.do".equals(url)){
			controll=new DetailController();
		}else if("/update.do".equals(url)){
			controll=new UpdateController();
		}
		String viewName=controll.execute(req);
		
		if(viewName.startsWith("redirect:")){
			resp.sendRedirect(viewName.replace("redirect:", ""));
			return;
		}
		
		viewName+=".jsp";
		
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
}















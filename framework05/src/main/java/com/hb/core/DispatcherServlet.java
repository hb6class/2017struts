package com.hb.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	Map<String, MyController> map = new HashMap<String, MyController>();
	Logger log = Logger.getLogger(this.getClass());
	 
	@Override
	public void init() throws ServletException {
		
		String root = this.getClass().getResource("/").getFile();
		File f = new File(root+"mybean.properties");
		Properties prop = new Properties();
		try {
			InputStream is=new FileInputStream(f);
			prop.load(is);
			Set<String> keys = prop.stringPropertyNames();
			for(String key : keys){
				Class<?> clzz = Class.forName(prop.getProperty(key));
				map.put(key, (MyController)clzz.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String uri=req.getRequestURI();
		int rootcnt=req.getContextPath().length();
		String url = uri.substring(rootcnt);
		
		MyController controll = map.get(url);
		String viewName = controll.execute(req);

		if(viewName==null){
			// err page
		}else if(viewName.startsWith("redirect:")){
			viewName=viewName.replace("redirect:", "");
			resp.sendRedirect(viewName);
			return;
		}
		String prefix="/WEB-INF/pages/";
		String suffix=".jsp";
		
		req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);
		
	}
}















package com.hb.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	// FrontController
	private Map<String,String> map;
//	Logger log= Logger.getLogger("com.hb.core.DispatcherServlet");
//	Logger log= Logger.getLogger(com.hb.core.DispatcherServlet.class);
//	Logger log= Logger.getLogger(this.getClass());
	Logger log= Logger.getLogger(this.getClass());
//	######################################################################
//	#%p debug, info, warn, error, fatal 등의 priority 가 출력된다. 
//	#%m 로그내용이 출력됩니다 
//	#%d 로깅 이벤트가 발생한 시간을 기록합니다.
//	# 포맷은 %d{HH:mm:ss, SSS}, %d{yyyy MMM dd HH:mm:ss, SSS}같은 형태로 사용하며 SimpleDateFormat에 따른 포맷팅을 하면 된다 
//	#%t 로그이벤트가 발생된 쓰레드의 이름을 출력합니다. 
//	#%% % 표시를 출력하기 위해 사용한다. 
//	#%n 플랫폼 종속적인 개행문자가 출력된다. \r\n 또는 \n 일것이다. 
//	#%c 카테고리를 표시합니다 
//	# 예) 카테고리가 a.b.c 처럼 되어있다면 %c{2}는 b.c가 출력됩니다. 
//	#%C 클래스명을 포시합니다. 
//	# 예)클래스구조가 org.apache.xyz.SomeClass 처럼 되어있다면 %C{2}는 xyz.SomeClass 가 출력됩니다 
//	#%F 로깅이 발생한 프로그램 파일명을 나타냅니다. 
//	#%l 로깅이 발생한 caller의 정보를 나타냅니다 
//	#%L 로깅이 발생한 caller의 라인수를 나타냅니다 
//	#%M 로깅이 발생한 method 이름을 나타냅니다. 
//	#%r 어플리케이션 시작 이후 부터 로깅이 발생한 시점의 시간(milliseconds) 
//	#%x 로깅이 발생한 thread와 관련된 NDC(nested diagnostic context)를 출력합니다. 
//	#%X 로깅이 발생한 thread와 관련된 MDC(mapped diagnostic context)를 출력합니다.
//
//	#######################################################################



	
	//	DEBUG < INFO < WARN < ERROR < FATAL
	
	// 주소:controller주소
	// /guest/list.do : com.hb.controller.ListController
	// /guest/add.do : com.hb.controller.AddController
	// /guest/insert.do : com.hb.controller.InsertController
	// /guest/detail.do : com.hb.controller.DetailController
	// /guest/edit.do : com.hb.controller.EditController
	// /guest/update.do : com.hb.controller.UpdateController
	
	// 1.정보담기 map<String,String>
	// 2.객체생성
	
	@Override
	public void init() throws ServletException {
		map=new HashMap<String, String>();
		map.put("/guest/list.do", "com.hb.controller.ListController");
		map.put("/guest/add.do", "com.hb.controller.AddController");
		map.put("/guest/insert.do", "com.hb.controller.InsertController");
		map.put("/guest/detail.do", "com.hb.controller.DetailController");
		map.put("/guest/edit.do", "com.hb.controller.EditController");
		map.put("/guest/update.do", "com.hb.controller.UpdateController");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String uri=req.getRequestURI();
		String url=uri.replace(req.getContextPath(),"");
		log.debug(map.get(url));
		log.info(map.get(url));
		log.warn(map.get(url));
		log.fatal(map.get(url));
		MyController controll=null;
		if(map.get(url)!=null){
			try {
				Class<?> clazz = Class.forName(map.get(url));
				controll=(MyController)clazz.newInstance();
			} catch (Exception e) {
				log.error("객체 생성 실패");
			}
		}
		String viewName = controll.execute(req);
		System.out.println(viewName);
		String prefix="/WEB-INF/page/";
		String suffix=".jsp";
		if(viewName.startsWith("redirect:")){
			resp.sendRedirect(viewName.replace("redirect:", ""));
		}else{
			req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);
		}
		
	}
}












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
//	#%p debug, info, warn, error, fatal ���� priority �� ��µȴ�. 
//	#%m �α׳����� ��µ˴ϴ� 
//	#%d �α� �̺�Ʈ�� �߻��� �ð��� ����մϴ�.
//	# ������ %d{HH:mm:ss, SSS}, %d{yyyy MMM dd HH:mm:ss, SSS}���� ���·� ����ϸ� SimpleDateFormat�� ���� �������� �ϸ� �ȴ� 
//	#%t �α��̺�Ʈ�� �߻��� �������� �̸��� ����մϴ�. 
//	#%% % ǥ�ø� ����ϱ� ���� ����Ѵ�. 
//	#%n �÷��� �������� ���๮�ڰ� ��µȴ�. \r\n �Ǵ� \n �ϰ��̴�. 
//	#%c ī�װ��� ǥ���մϴ� 
//	# ��) ī�װ��� a.b.c ó�� �Ǿ��ִٸ� %c{2}�� b.c�� ��µ˴ϴ�. 
//	#%C Ŭ�������� �����մϴ�. 
//	# ��)Ŭ���������� org.apache.xyz.SomeClass ó�� �Ǿ��ִٸ� %C{2}�� xyz.SomeClass �� ��µ˴ϴ� 
//	#%F �α��� �߻��� ���α׷� ���ϸ��� ��Ÿ���ϴ�. 
//	#%l �α��� �߻��� caller�� ������ ��Ÿ���ϴ� 
//	#%L �α��� �߻��� caller�� ���μ��� ��Ÿ���ϴ� 
//	#%M �α��� �߻��� method �̸��� ��Ÿ���ϴ�. 
//	#%r ���ø����̼� ���� ���� ���� �α��� �߻��� ������ �ð�(milliseconds) 
//	#%x �α��� �߻��� thread�� ���õ� NDC(nested diagnostic context)�� ����մϴ�. 
//	#%X �α��� �߻��� thread�� ���õ� MDC(mapped diagnostic context)�� ����մϴ�.
//
//	#######################################################################



	
	//	DEBUG < INFO < WARN < ERROR < FATAL
	
	// �ּ�:controller�ּ�
	// /guest/list.do : com.hb.controller.ListController
	// /guest/add.do : com.hb.controller.AddController
	// /guest/insert.do : com.hb.controller.InsertController
	// /guest/detail.do : com.hb.controller.DetailController
	// /guest/edit.do : com.hb.controller.EditController
	// /guest/update.do : com.hb.controller.UpdateController
	
	// 1.������� map<String,String>
	// 2.��ü����
	
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
				log.error("��ü ���� ����");
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












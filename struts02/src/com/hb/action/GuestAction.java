package com.hb.action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.validator.Validator;

public class GuestAction implements Preparable,ModelDriven<GuestVo>{
	// POJO 지향(2.x)
//	private Map<String, Object> userSession ;
//
//	public void setSession(Map<String, Object> session) {
//	   userSession = session ;
//	}
	private Map<String,String> errs;
	private GuestVo bean;
	private List<GuestVo> list;
	
	public Map<String, String> getErrs() {
		return errs;
	}
	public GuestVo getBean() {
		return bean;
	}
	public List<GuestVo> getList() {
		return list;
	}
	
	public String delOne() throws Exception {
		GuestDao dao= new GuestDao();
		int result=dao.delOne(bean.getSabun());
		if(result>0)return "success";
		return "error";
	}
	public String updateOne() throws Exception {
		if(validate())return "input";
		GuestDao dao= new GuestDao();
		int result=dao.editOne(bean);
		if(result>0)return "success";
		return "error";
	}
	
	public String detail() throws SQLException{
		GuestDao dao = new GuestDao();
		bean=dao.selectOne(bean.getSabun());
		return "success";
	}

	private boolean validate() {
		errs=new HashMap<String, String>();
		if(bean==null){
			return true;
		}else if(bean.getName().equals("")){
			errs.put("errName", "이름을 입력하세요");
			return true;
		}else if(bean.getName().length()<4){
			errs.put("errName", "이름은 4자이상입니다");
			return true;
		}else if(bean.getPay()<0){
			errs.put("errPay", "금액은 0원 이상입니다");
			return true;
		}
		return false;
	}
	
	public String insertOne() throws SQLException {
		GuestDao dao = new GuestDao();
		if(validate())return "input";
		dao.insertOne(bean);
		return "success";
	}
	
	@Override
	public GuestVo getModel() {
		return bean;
	}
	
	@Override
	public void prepare() throws Exception {
		bean=new GuestVo();
	}
	
	public String addForm(){
		return "success";
	}
	
	public String execute() throws SQLException {
		ActionContext ctxt = ActionContext.getContext();
		Map<String, Object> session = ctxt.getSession();
		
		GuestDao dao = new GuestDao();
		list=dao.selectAll();		
		return "success";
	}
}

package com.hb.action;

import com.opensymphony.xwork2.ActionSupport;

public class InputAction extends ActionSupport {
	String id,pw;
//	public String getId() {
//		return id;
//	}
//	public String getPw() {
//		return pw;
//	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String formShow(){
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(id+":"+pw);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		if(id==null || "".equals(id)){
			addFieldError("id", "���̵� �����");
		}
		if(pw==null || "".equals(pw)){
			addFieldError("pw", "��й�ȣ �����");
		}
	}
}















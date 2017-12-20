package com.hb.action;

import com.hb.model.GuestDao;
import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport {
	private String name;
	private int pay;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getPay() {
		return pay;
	}

	@Override
	public String execute() throws Exception {
		GuestDao dao = new GuestDao();
		dao.addOne(name,pay);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		System.out.println("validate()");
		if(name==null || "".equals(name)){
			name=name.trim();
			addFieldError("nameErr", "이름을 입력하세요");
		}
		if(pay==0){
			addFieldError("payErr", "금액을 입력하세요");
		}
		if(pay<=0){
			addFieldError("payErr", "0보다 커야 합니다");
		}
	}
}
























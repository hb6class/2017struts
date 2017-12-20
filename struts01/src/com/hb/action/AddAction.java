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
			addFieldError("nameErr", "�̸��� �Է��ϼ���");
		}
		if(pay==0){
			addFieldError("payErr", "�ݾ��� �Է��ϼ���");
		}
		if(pay<=0){
			addFieldError("payErr", "0���� Ŀ�� �մϴ�");
		}
	}
}
























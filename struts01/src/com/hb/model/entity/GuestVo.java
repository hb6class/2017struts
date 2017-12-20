package com.hb.model.entity;

import java.sql.Date;

public class GuestVo {
	private int sabun;
	private String name;
	private Date nalja;
	private int pay;
	public GuestVo() {
	}
	public GuestVo(int sabun, String name, Date nalja, int pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.nalja = nalja;
		this.pay = pay;
	}
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getNalja() {
		return nalja;
	}
	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	@Override
	public String toString() {
		return "GuestVo [sabun=" + sabun + ", name=" + name + ", nalja="
				+ nalja + ", pay=" + pay + "]";
	}
	
}

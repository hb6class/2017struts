package com.hb.model.entity;

import java.sql.Date;

public class GuestDto {
	private int sabun;
	private String name;
	private Date nalja;
	private int pay;
	
	public GuestDto() {
		// TODO Auto-generated constructor stub
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
		return "GuestDto [sabun=" + sabun + ", name=" + name + ", nalja="
				+ nalja + ", pay=" + pay + "]";
	}
	
	
}

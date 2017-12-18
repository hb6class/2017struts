package com.hb.model;

import java.util.List;

import com.hb.model.entity.GuestVo;

public class GuestDaoTest {
	
	public static void insertOneTest(){
		GuestDao dao = new GuestDao();
		GuestVo bean = new GuestVo();
		bean.setSabun(8888);
		bean.setName("test");
		bean.setPay(8000);
		int result;
		try {
			result = dao.insertOne(bean);
			System.out.println("°á°ú"+(result>0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectAllTest(){
		GuestDao dao = new GuestDao();
		List<GuestVo> list;
		try {
			list = dao.selectAll();
			for(GuestVo bean : list){
				System.out.println(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public static void main(String[] args) {
		selectAllTest();
	}

}

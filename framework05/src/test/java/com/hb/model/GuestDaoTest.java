package com.hb.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hb.model.entity.GuestVo;

public class GuestDaoTest {
	static GuestDao dao;
	GuestVo bean;
	
//	public GuestDaoTest() {
//		dao = new GuestDao();
//	}
	@BeforeClass
	public static void beforeClass(){
		// init
		System.out.println("테스트 시작");
		dao = new GuestDao();
	}
	
	@AfterClass
	public static void afterClass(){
		// destroy
		System.out.println("테스트 종료");
	}
	
	@Before
	public void beforeTest(){
		bean = new GuestVo();
		bean.setSabun(7777);
		bean.setName("test");
		bean.setPay(7000);
	}
	@After
	public void afterTest(){
		bean.setName("test");
	}

	@Test
	public void deleteOneTest() throws Exception{
		dao.insertOne(bean);
		Assert.assertTrue(dao.deleteOne(7777)>0);
	}
	
	@Test
	public void insertOneTest() throws Exception{
		dao.insertOne(bean);
		// 입력을 했기에 들어 있을 것이다
		Assert.assertEquals(bean,dao.selectOne(bean.getSabun()));
		dao.deleteOne(bean.getSabun());
		////////////////////////////////
		// result>0
		//org.junit.Assert.assertTrue(result>0);
		// 예상이 true이냐
		
	}
	
	@Test
	public void selectOneTest() throws Exception{
		GuestVo bean = dao.selectOne(9999);
		// 9999검색을 했을때 나오는 빈의 사번은 9999 이어야 한다
//		Assert.assertSame(bean2, bean2);
		Assert.assertEquals(9999, bean.getSabun());
	}
	
	public void editOneTest() throws Exception{
		bean.setName("test2");
		int result=dao.editOne(bean);
		Assert.assertTrue(result>0);
		Assert.assertEquals(bean.getName()
				, dao.selectOne(bean.getSabun()).getName());
	}
	
}
















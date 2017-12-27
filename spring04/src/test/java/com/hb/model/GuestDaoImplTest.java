package com.hb.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.hb.model.entity.GuestVo;

public class GuestDaoImplTest {
	GuestDao dao;
	private GuestVo testBean;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory beans = new XmlBeanFactory(resource);
		dao=(GuestDao) beans.getBean("guestDao");
		
		testBean=new GuestVo(9999,"test",null,9000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAll() throws Exception {
		assertNotNull(dao);
		List<GuestVo> list = dao.selectAll();
		assertNotNull(list);
		assertTrue(list.size()>0);
	}
	@Test
	public void testSelectOne() throws Exception {
		dao.insertOne(testBean);
		GuestVo bean = dao.selectOne(testBean.getSabun());
		assertNotNull(bean);
		assertEquals(testBean.getSabun(), bean.getSabun());
		assertEquals(testBean, bean);
		testDeleteOne();
	}

//	@Test
	public void testDeleteOne() throws Exception{
		assertSame(1, dao.deleteOne(testBean.getSabun()));
	}
	@Test
	public void testUpdateOne() throws Exception{
		dao.insertOne(testBean);
		GuestVo bean =new GuestVo(testBean.getSabun()
				, "edit", null, 0);
		assertSame(1, dao.updateOne(bean));
		GuestVo testBean=dao.selectOne(bean.getSabun());
		assertEquals(bean, testBean);
		dao.deleteOne(bean.getSabun());
	}
}

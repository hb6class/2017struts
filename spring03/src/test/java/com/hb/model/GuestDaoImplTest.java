package com.hb.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.sql.DataSource;

import org.apache.catalina.deploy.ContextResource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.context.support.ServletContextResource;

import com.hb.model.entity.GuestVo;

public class GuestDaoImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testBean=new GuestVo(13, "test99", null, 9999);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private GuestDaoImpl dao;
	private static GuestVo testBean;
	private int cnt;
	
	@Before
	public void setUp() throws Exception {
//		BasicDataSource dataSource=new BasicDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/xe");
//		dataSource.setUsername("scott");
//		dataSource.setPassword("tiger");
//		
//		dao= new GuestDaoImpl();
//		dao.setDataSource(dataSource);
		Resource resource = new FileSystemResource("C:\\ztest\\spring03\\src\\main\\webapp\\WEB-INF\\root-context.xml");
		BeanFactory beans = new XmlBeanFactory(resource);
		dao=(GuestDaoImpl) beans.getBean("guestDao");
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testDao() throws Exception{
		testInsertOne();
		testSelectAll();
		testBean.setSabun(dao.maxSabun()+1);
		testInsertOne();
		testSelectOne();
		testUpdateOne();
		testDeleteOne();
	}

//	@Test
	public void testSelectAll() throws Exception {
		List<GuestVo> list = dao.selectAll();
		Assert.assertNotNull(list);
		assertTrue(list.size()>0);
	}

//	@Test
	public void testInsertOne() throws Exception {
		dao.insertOne(testBean);
	}
//	@Test
	public void testSelectOne() throws Exception {
		GuestVo bean = dao.selectOne(testBean.getSabun());
//		GuestVo bean = dao.selectOne(33);
		Assert.assertNotNull(bean);
		Assert.assertEquals(testBean.getName(), bean.getName());
		Assert.assertEquals(testBean.getPay(), bean.getPay());
	}
//	@Test
	public void testUpdateOne() throws Exception {
		testBean.setName("test");
		int result=dao.updateOne(testBean);
		Assert.assertTrue(result>0);
		testBean.setName("test99");
	}
//	@Test
	public void testDeleteOne() throws Exception {
		int result=dao.deleteOne(testBean.getSabun());
		Assert.assertTrue(result>0);
	}

}














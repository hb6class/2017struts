package com.hb.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyOraTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetConnection(){
		Connection conn;
		try {
			conn = MyOra.getConnection();
		// 객체 받아오는지
		assertNotNull(conn);
		// 싱글톤인지
		assertEquals(conn, MyOra.getConnection());
		// close()했을때는 새로운 객체를 받아와야함
		conn.close();
		assertNotEquals(conn, MyOra.getConnection());
		} catch (Exception e) {
			fail("문제 있음:"+e.getMessage());
		}
		
		
	}

}


















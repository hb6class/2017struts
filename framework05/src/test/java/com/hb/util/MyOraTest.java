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
		// ��ü �޾ƿ�����
		assertNotNull(conn);
		// �̱�������
		assertEquals(conn, MyOra.getConnection());
		// close()�������� ���ο� ��ü�� �޾ƿ;���
		conn.close();
		assertNotEquals(conn, MyOra.getConnection());
		} catch (Exception e) {
			fail("���� ����:"+e.getMessage());
		}
		
		
	}

}


















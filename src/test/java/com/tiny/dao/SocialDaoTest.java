package com.tiny.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;

public class SocialDaoTest extends CommonTest {
	@Autowired
	private SocialDao socialDao;
	
	@Test
	public void testCreateUserConnection() {
		socialDao.createUserConnection();
	}
}
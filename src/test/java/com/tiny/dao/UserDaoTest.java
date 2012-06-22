package com.tiny.dao;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;
import com.tiny.domain.User;

public class UserDaoTest extends CommonTest {
	@Autowired
	UserDao userDao;

	@Before
	public void before() {
		userDao.dropUser();
		userDao.createUser();
	}
	
	@After
	public void after() {
		userDao.dropUser();
	}

	@Test
	public void testInsertUser() {
		userDao.saveUser(new User("name", "tiny", "password"));
	}
	
	@Test
	public void testUpdateUser() {
		userDao.updateUser(new User("name", "tiny4", "pass"));
	}
	
	@Test
	public void testGetUser() {
		User user = userDao.getUser("test");
		assertThat(user.getCompany(), is("tiny"));
	}
	
	@Test
	public void testDeleteUser() {
		userDao.deleteUser("name");
	}
}

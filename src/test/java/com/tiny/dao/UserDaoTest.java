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
		assertThat(userDao.countUser(), is(0));
		userDao.saveUser(new User("name", "tiny", "password"));
		assertThat(userDao.countUser(), is(1));
	}
	
	@Test
	public void testUpdateUser() {
		userDao.saveUser(new User("name", "tiny", "password"));
		assertThat(userDao.countUser(), is(1));
		
		userDao.updateUser(new User("name", "tiny2", "password"));
		assertThat(userDao.countUser(), is(1));
	}
	
	@Test
	public void testGetUser() {
		userDao.saveUser(new User("name", "tiny", "password"));
		User user = userDao.getUser("name");
		assertThat(user.getCompany(), is("tiny"));
	}
	
	@Test
	public void testDeleteUser() {
		userDao.saveUser(new User("name", "tiny", "password"));
		assertThat(userDao.countUser(), is(1));
		
		userDao.deleteUser("name");
		assertThat(userDao.countUser(), is(0));
	}
}

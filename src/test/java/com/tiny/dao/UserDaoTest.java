package com.tiny.dao;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;
import com.tiny.user.User;

public class UserDaoTest extends CommonTest {
	@Autowired
	UserDao userDao;

	@Before
	public void before() {
		userDao.createUser();
	}

	@Test
	public void testInsertUser() {
		int count = userDao.countUser();
		userDao.saveUser(new User("name", "tiny", "password"));
		assertThat(userDao.countUser(), is(count + 1));
	}

	@Test
	public void testUpdateUser() {
		userDao.saveUser(new User("name", "tiny", "password"));
		int count = userDao.countUser();

		userDao.updateUser(new User("name", "tiny2", "password"));
		assertThat(userDao.countUser(), is(count));
	}

	@Test
	public void testGetUser() {
		userDao.saveUser(new User("get_name", "get_test", "password"));
		User user = userDao.getUser("get_name");
		assertThat(user.getCompany(), is("get_test"));
	}

	@Test
	public void testDeleteUser() {
		userDao.saveUser(new User("delete_name", "tiny", "password"));
		int count = userDao.countUser();

		userDao.deleteUser("delete_name");
		assertThat(userDao.countUser(), is(count - 1));
	}
}

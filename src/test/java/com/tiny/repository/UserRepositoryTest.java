package com.tiny.repository;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;
import com.tiny.model.User;

public class UserRepositoryTest extends CommonTest {
	@Autowired
	UserRepository userRepository;

	@Before
	public void before() {
		userRepository.createUser();
	}

	@Test
	public void testInsertUser() {
		userRepository.insertUser(new User("name", "pass"));
	}
}

package com.tiny.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;

public class UserControllerTest extends CommonTest {
	@Autowired
	UserController userController;

	@Test
	public void testHome() {
		userController.home();
	}
}

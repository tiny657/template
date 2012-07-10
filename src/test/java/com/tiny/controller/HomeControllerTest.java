package com.tiny.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;

public class HomeControllerTest extends CommonTest {
	@Autowired
	private HomeController homeController;
	
	@Test
	public void testHome() {
		homeController.home();
	}
}
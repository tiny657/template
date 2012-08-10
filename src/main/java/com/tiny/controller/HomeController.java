package com.tiny.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	private final Facebook facebook;

	@Inject
	public HomeController(Facebook facebook) {
		this.facebook = facebook;
	}

	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public ModelAndView home() {
		LOGGER.info("homeController");
		ModelAndView mav = new ModelAndView();
		List<Reference> friends = facebook.friendOperations().getFriends();
		mav.setViewName("home");
		mav.addObject("friends", friends);
		return mav;
	}
}

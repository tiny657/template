package com.tiny.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private Facebook facebook;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView home(SitePreference sitePreference) {
		LOGGER.info("homeController");
		ModelAndView mav = new ModelAndView();
		List<Reference> friends = facebook.friendOperations().getFriends();
		if (SitePreference.MOBILE == sitePreference) {
			mav.setViewName("homeM");
		} else {
			mav.setViewName("home");
		}
		mav.addObject("friends", friends);
		return mav;
	}
}

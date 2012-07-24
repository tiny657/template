package com.tiny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(SitePreference sitePreference) {
		LOGGER.info("homeController");
		ModelAndView mav = new ModelAndView();
		if (sitePreference == SitePreference.MOBILE) {
			mav.setViewName("homeMobile");
		} else {
			mav.setViewName("home");
		}
		return mav;
	}
}

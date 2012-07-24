package com.tiny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MobileController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MobileController.class);

	@RequestMapping(value = "/mobile", method = { RequestMethod.GET })
	public ModelAndView getDeviceInfo(SitePreference sitePreference) {
		ModelAndView mav = new ModelAndView();
		if (sitePreference == SitePreference.MOBILE) {
			mav.setViewName("mobileMobile");
		} else {
			mav.setViewName("mobile");
		}
		return mav;
	}
}

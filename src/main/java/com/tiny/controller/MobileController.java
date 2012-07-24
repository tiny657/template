package com.tiny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MobileController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MobileController.class);

	@RequestMapping(value = "/mobile", method = { RequestMethod.GET })
	public ModelAndView getDeviceInfo(Device device) {
		LOGGER.info("mobileController");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mobile");
		return mav;
	}
	
	@RequestMapping(value = "/m/mobile", method = { RequestMethod.GET })
	public ModelAndView getDeviceInfoM() {
		LOGGER.info("mobileControllerM");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mobileM");
		return mav;
	}
}

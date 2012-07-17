package com.tiny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.wurfl.WurflDevice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MobileController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MobileController.class);

	private WurflDevice wurflDevice;

	@RequestMapping(value = "/mobile", method = { RequestMethod.GET })
	public ModelAndView wurfl(Device device) {
		ModelAndView mav = new ModelAndView();
		wurflDevice = new WurflDevice((net.sourceforge.wurfl.core.Device) device);

		LOGGER.info("isMobile : " + wurflDevice.isMobile());
		LOGGER.info("getId : " + wurflDevice.getId());
		LOGGER.info("getUserAgent : " + wurflDevice.getUserAgent());
		LOGGER.info("getCapabilities : " + wurflDevice.getCapabilities());
		LOGGER.info("getCapability(model_name) : " + wurflDevice.getCapability("model_name"));
		LOGGER.info("getCapability(device_os) : " + wurflDevice.getCapability("device_os"));
		LOGGER.info("getCapability(device_os_version) : " + wurflDevice.getCapability("device_os_version"));
		LOGGER.info("getCapability(mobile_browser) : " + wurflDevice.getCapability("mobile_browser"));
		LOGGER.info("getMarkUp : " + wurflDevice.getMarkUp());
		mav = new ModelAndView();
		mav.setViewName("mobile");

		return mav;
	}
}

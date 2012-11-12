package com.tiny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tiny.common.util.Constant;
import com.tiny.service.MarketService;

@Controller
public class MarketController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MarketController.class);

	@Autowired
	private MarketService marketService;

	@RequestMapping(value = { "/market" }, method = RequestMethod.GET)
	public ModelAndView getFriends() {
		ModelAndView mav = new ModelAndView();
		ModelMap model = new ModelMap();
		model.addAttribute("items", marketService.getAll());
		model.addAttribute("url", Constant.MARKET);
		mav.addAllObjects(model);
		mav.setViewName("market");
		return mav;
	}
}
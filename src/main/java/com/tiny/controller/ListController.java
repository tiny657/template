package com.tiny.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tiny.document.Document;
import com.tiny.service.ListService;

@Controller
public class ListController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ListController.class);

	@Autowired
	private ListService listService;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		ModelMap model = new ModelMap();
		model.addAttribute("documents", listService.getAll());
		model.addAttribute("newDocument", new Document());
		mav.addAllObjects(model);
		mav.setViewName("list");
		return mav;
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, @ModelAttribute Document document) {
		document.setIpAddress(request.getRemoteAddr());
		listService.register(document);
		return list();
	}
}
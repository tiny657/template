package com.tiny.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tiny.service.FacebookService;
import com.tiny.service.MemberService;

@Controller
public class MemberController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private FacebookService facebookService;

	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
	public ModelAndView profile() {
		ModelAndView mav = new ModelAndView();
		ModelMap model = new ModelMap();
		model.addAttribute("member", memberService.getMember(facebookService.getProfile()));
		model.addAttribute("url", "profile");
		mav.addAllObjects(model);
		mav.setViewName("member");
		return mav;
	}

	@RequestMapping(value = { "/profileImage" }, method = RequestMethod.GET)
	public void profileImage(HttpServletResponse response) {
		byte[] userProfileImage = facebookService.getProfileImage();
		response.setContentType("image/jpeg");
		try {
			response.getOutputStream().write(userProfileImage);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e1) {
			LOGGER.error("IOException");
		}
	}
}
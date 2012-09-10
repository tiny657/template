package com.tiny.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tiny.service.MemberService;

@Controller
public class MemberController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private Facebook facebook;
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
	public ModelAndView profile() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member");
		ModelMap model = new ModelMap();
		model.addAttribute("member", memberService.getMember());
		mav.addAllObjects(model);
		return mav;
	}
	
	@RequestMapping(value = { "/profileImage" }, method = RequestMethod.GET)
	public void profileImage(HttpServletResponse response) {
		byte[] userProfileImage = facebook.userOperations().getUserProfileImage(); 
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
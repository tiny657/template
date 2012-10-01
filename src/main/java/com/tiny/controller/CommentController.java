package com.tiny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tiny.comment.Comment;
import com.tiny.service.CommentService;
import com.tiny.service.MemberService;
import com.tiny.social.SecurityContext;

@Controller
public class CommentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam Integer documentId, @RequestParam String content) {
		ModelAndView mav = new ModelAndView();
		ModelMap model = new ModelMap();
		Comment comment = new Comment();
		comment.setDocumentId(documentId);
		comment.setContent(content);
		model.addAttribute("comment", commentService.saveAndGet(comment));
		model.addAttribute("member", memberService.getMember(SecurityContext.getCurrentUser().getId()));
		mav.addAllObjects(model);
		mav.setViewName("comment");
		return mav;
	}

	@RequestMapping(value = { "/comment" }, method = RequestMethod.DELETE)
	public void delete(@RequestParam Integer commentId) {
		commentService.delete(commentId);
	}
}
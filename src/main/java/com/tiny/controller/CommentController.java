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

@Controller
public class CommentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam Integer documentId, @RequestParam String content) {
		Comment comment = new Comment();
		comment.setDocumentId(documentId);
		comment.setContent(content);
		commentService.save(comment);
		
		ModelAndView mav = new ModelAndView();
		ModelMap model = new ModelMap();
		model.addAttribute("comment", comment);
		mav.addAllObjects(model);
		mav.setViewName("comment");
		return mav;
	}
}
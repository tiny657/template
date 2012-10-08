package com.tiny.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.tiny.common.util.Constant;
import com.tiny.document.Document;
import com.tiny.service.CommentService;
import com.tiny.service.DocumentService;
import com.tiny.service.MemberService;
import com.tiny.social.SecurityContext;

@Controller
public class ListController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ListController.class);

	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		// update lastLogin time
		memberService.updateLastLogin(SecurityContext.getCurrentUser().getId());
		
		ModelAndView mav = new ModelAndView();
		ModelMap model = new ModelMap();
		List<Document> documents = documentService.getAll();
		model.addAttribute("documents", documents);
		model.addAttribute("newDocument", new Document());
		Map<String, List<Comment>> map = new HashMap<String, List<Comment>>();
		for (Document document : documents) {
			model.addAttribute("newComment" + document.getDocumentId(), new Comment());
			List<Comment> comments = commentService.get(document.getDocumentId());
			map.put(Integer.toString(document.getDocumentId()), comments);
		}
		model.addAttribute("comments", map);
		model.addAttribute("url", Constant.LIST);
		model.addAttribute("member", memberService.get(SecurityContext.getCurrentUser().getId()));
		mav.addAllObjects(model);
		mav.setViewName("list");
		return mav;
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public ModelAndView search(@RequestParam String q) {
		return list();
	}
}
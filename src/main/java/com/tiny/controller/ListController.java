package com.tiny.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tiny.comment.Comment;
import com.tiny.document.Document;
import com.tiny.service.CommentService;
import com.tiny.service.ListService;

@Controller
public class ListController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ListController.class);

	@Autowired
	private ListService listService;

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = { "/document" }, method = RequestMethod.POST)
	public ModelAndView saveDocument(HttpServletRequest request, @ModelAttribute Document document) {
		// register form data
		document.setIpAddress(request.getRemoteAddr());

		ModelAndView mav = new ModelAndView();
		ModelMap model = new ModelMap();
		model.addAttribute("document", listService.saveTransactional(document));
		mav.addAllObjects(model);
		mav.setViewName("document");
		return mav;
	}

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		ModelMap model = new ModelMap();
		List<Document> documents = listService.getAll();
		model.addAttribute("documents", documents);
		model.addAttribute("newDocument", new Document());
		Map<String, List<Comment>> map = new HashMap<String, List<Comment>>();
		for (Document document : documents) {
			model.addAttribute("newComment" + document.getDocumentId(), new Comment());
			List<Comment> comments = commentService.getComments(document.getDocumentId());
			map.put(Integer.toString(document.getDocumentId()), comments);
		}
		model.addAttribute("comments", map);
		model.addAttribute("url", "list");
		mav.addAllObjects(model);
		mav.setViewName("list");
		return mav;
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.DELETE)
	public ModelAndView delete(@RequestParam Integer documentId) {
		commentService.deleteWithDocumentId(documentId);
		listService.delete(documentId);
		return list();
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public ModelAndView search(@RequestParam String q) {
		return list();
	}
}
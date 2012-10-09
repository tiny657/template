package com.tiny.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.DuplicateStatusException;
import org.springframework.social.RateLimitExceededException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.tiny.comment.Comment;
import com.tiny.common.util.Constant;
import com.tiny.document.Document;
import com.tiny.service.CommentService;
import com.tiny.service.DocumentService;
import com.tiny.service.MemberService;
import com.tiny.service.PostService;
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

	@Autowired
	private PostService postService;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		// initial access
		if (!memberService.isExisted(SecurityContext.getCurrentUser().getId())) {
			return new ModelAndView(new RedirectView("/member"));
		}

		// update lastLogin time
		memberService.updateLastLoginTime(SecurityContext.getCurrentUser().getId());

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
		// for posting
		model.addAttribute("member", memberService.get(SecurityContext.getCurrentUser().getId()));
		mav.addAllObjects(model);
		mav.setViewName("list");
		return mav;
	}

	@RequestMapping(value = "/list/{documentId}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable Integer documentId) {
		ModelAndView mav = new ModelAndView();
		ModelMap model = new ModelMap();
		Document document = documentService.get(documentId);
		if (document == null) {
			return new ModelAndView(new RedirectView("/list"));
		}
		model.addAttribute("document", document);
		Map<String, List<Comment>> map = new HashMap<String, List<Comment>>();
		model.addAttribute("newComment" + document.getDocumentId(), new Comment());
		List<Comment> comments = commentService.get(document.getDocumentId());
		map.put(Integer.toString(document.getDocumentId()), comments);
		model.addAttribute("comments", map);
		model.addAttribute("url", Constant.LIST);
		// for posting
		try {
			model.addAttribute("member", memberService.get(SecurityContext.getCurrentUser().getId()));
			mav.setViewName("listOne");
		} catch (IllegalStateException e) {
			LOGGER.info("No user logined in.");
			mav.setViewName("listOneNotLogin");
		}
		mav.addAllObjects(model);
		return mav;
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ModelAndView post(@RequestParam String content) {
		ModelAndView mav = new ModelAndView();
		ModelMap model = new ModelMap();
		try {
			postService.post(content);
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Posted.");
		} catch (DuplicateStatusException e) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Already Posted.");
		} catch (UncategorizedApiException e) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Content is empty.");
		} catch (RateLimitExceededException e) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "The rate limit has been exceeded.");
		} catch (Exception e) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Error.");
		}
		mav.addAllObjects(model);
		mav.setViewName("postAlert");
		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam String q) {
		return list();
	}
}
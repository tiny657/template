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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tiny.document.Document;
import com.tiny.service.CommentService;
import com.tiny.service.DocumentService;
import com.tiny.service.MemberService;
import com.tiny.social.SecurityContext;

@Controller
public class DocumentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);

	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = { "/document" }, method = RequestMethod.POST)
	public ModelAndView saveDocument(HttpServletRequest request, @ModelAttribute Document document) {
		ModelAndView mav = new ModelAndView();
		ModelMap model = new ModelMap();
		document.setIpAddress(request.getRemoteAddr());
		model.addAttribute("document", documentService.saveAndGet(document));
		model.addAttribute("member", memberService.get(SecurityContext.getCurrentUser().getId()));
		mav.addAllObjects(model);
		mav.setViewName("document");
		return mav;
	}

	@RequestMapping(value = { "/document" }, method = RequestMethod.DELETE)
	public void delete(@RequestParam Integer documentId) {
		commentService.deleteWithDocumentId(documentId);
		documentService.delete(documentId);
	}
}
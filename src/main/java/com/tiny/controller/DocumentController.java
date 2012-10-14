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
import com.tiny.repository.UserConnectionRepository;
import com.tiny.service.CommentService;
import com.tiny.service.DocumentService;
import com.tiny.service.MemberService;
import com.tiny.service.PointService;
import com.tiny.social.SecurityContext;

@Controller
public class DocumentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private DocumentService documentService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private PointService pointService;

	@Autowired
	private UserConnectionRepository userConnectionRepository;

	@RequestMapping(value = { "/document" }, method = RequestMethod.POST)
	public ModelAndView saveDocument(HttpServletRequest request, @ModelAttribute Document document) {
		ModelAndView mav = new ModelAndView();
		if (memberService.isChanceToDoc()) {
			ModelMap model = new ModelMap();
			document.setIpAddress(request.getRemoteAddr());
			model.addAttribute("document", documentService.saveAndGet(document));
			String providerUserId = userConnectionRepository.getProviderUserId(SecurityContext.getCurrentUser().getId());
			model.addAttribute("providerUserId", providerUserId);
			pointService.calculatePointToSaveDocument(providerUserId);
			memberService.decreaseChanceToDoc(providerUserId);
			mav.addAllObjects(model);
			mav.setViewName("document");
		}
		else {
			mav.setViewName("null");
		}
		return mav;
	}

	@RequestMapping(value = { "/document" }, method = RequestMethod.DELETE)
	public void delete(@RequestParam Integer documentId) {
		String providerUserId = userConnectionRepository.getProviderUserId(SecurityContext.getCurrentUser().getId());
		pointService.calculatePointToDeleteDocument(providerUserId, documentId);
		memberService.increaseChanceToDoc(providerUserId);
		commentService.deleteWithDocumentId(documentId);
		documentService.delete(documentId);
	}
}
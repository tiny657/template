package com.tiny.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;

import com.tiny.common.util.XssFilter;
import com.tiny.document.Document;
import com.tiny.repository.ListRepository;

@Service
public class ListService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ListService.class);
	
	@Autowired
	private XssFilter xssFilter;

	@Autowired
	private ListRepository listRepository;

	@Autowired
	private Facebook facebook;

	public void register(Document document) {
		document.setUserId(getUserId());
		document.setTitle(xssFilter.doFilter(document.getTitle()));
		document.setContent(xssFilter.doFilter(document.getContent()));
		document.setRegDate(new java.sql.Date(java.util.Calendar.getInstance().getTimeInMillis()));
		document.setLastUpdate(new java.sql.Date(java.util.Calendar.getInstance().getTimeInMillis()));
		listRepository.register(document);
	}

	public List<Document> getAll() {
		List<Document> documents = listRepository.getAll();
		for (Document document : documents) {
			document.setContent(document.getContent().replace("\r\n", "<br>").replace(" ", "&nbsp"));
		}

		return documents;
	}

	public String getUserId() {
		return facebook.userOperations().getUserProfile().getName();
	}
}

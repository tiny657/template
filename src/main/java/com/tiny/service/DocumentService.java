package com.tiny.service;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiny.common.util.XssFilter;
import com.tiny.document.Document;
import com.tiny.repository.DocumentRepository;

@Service
public class DocumentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentService.class);
	
	@Autowired
	private XssFilter xssFilter;

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private FacebookService facebookService;

	public void save(Document document) {
		FacebookProfile facebookProfile = facebookService.getProfile();
		document.setProviderUserId(facebookProfile.getId());
		document.setName(facebookProfile.getName());
		document.setContent(xssFilter.doFilter(document.getContent()));
		document.setRegDate(new Date(java.util.Calendar.getInstance().getTimeInMillis()));
		documentRepository.save(document);
	}
	
	@Transactional
	public Document saveAndGet(Document document) {
		save(document);
		return documentRepository.getLast();
	}

	public List<Document> getAll() {
		List<Document> documents = documentRepository.getAll();
		for (Document document : documents) {
			document.setContent(document.getContent().replace("\r\n", "<br>").replace(" ", "&nbsp"));
		}

		return documents;
	}
	
	public Document get(Integer documentId) {
		return documentRepository.get(documentId);
	}
	
	public Document getLast() {
		return documentRepository.getLast();
	}
	
	public void increaseCountToShare(Integer documentId) {
		documentRepository.increaseCountToShare(documentId);
	}
	
	public void delete(Integer documentId) {
		documentRepository.delete(documentId);
	}
}
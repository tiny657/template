package com.tiny.service;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiny.common.util.XssFilter;
import com.tiny.document.Document;
import com.tiny.repository.DocumentRepository;
import com.tiny.repository.MemberRepository;
import com.tiny.repository.UserConnectionRepository;
import com.tiny.social.SecurityContext;

@Service
public class DocumentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentService.class);

	@Autowired
	private XssFilter xssFilter;

	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private UserConnectionRepository userConnectionRepository;

	public void save(Document document) {
		String providerUserId = userConnectionRepository.getProviderUserId(SecurityContext.getCurrentUser().getId());
		document.setProviderUserId(providerUserId);
		document.setName(memberRepository.getName(providerUserId));
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

	public Document get(int documentId) {
		return documentRepository.get(documentId);
	}

	public Document getLast() {
		return documentRepository.getLast();
	}
	
	public void delete(int documentId) {
		documentRepository.delete(documentId);
	}
}
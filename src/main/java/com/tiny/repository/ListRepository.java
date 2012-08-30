package com.tiny.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tiny.dao.DocumentDao;
import com.tiny.document.Document;

@Repository
public class ListRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(ListRepository.class);
	
	@Autowired
	private DocumentDao documentDao;
	
	public void register(Document document) {
		documentDao.saveDocument(document);
	}
	
	public List<Document> getAll() {
		return documentDao.getAllDocument();
	}
}

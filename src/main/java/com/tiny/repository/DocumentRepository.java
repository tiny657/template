package com.tiny.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tiny.dao.DocumentDao;
import com.tiny.document.Document;

@Repository
public class DocumentRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentRepository.class);

	@Autowired
	private DocumentDao documentDao;

	public void save(Document document) {
		documentDao.save(document);
	}

	public List<Document> getAll() {
		return documentDao.getAll();
	}
	
	public Document get(int documentId) {
		return documentDao.get(documentId);
	}
	
	public Document getLast() {
		return documentDao.getLast();
	}

	public void increaseSharing(int documentId) {
		documentDao.increaseSharing(documentId);
	}
	
	public void decreaseSharing(int documentId) {
		documentDao.decreaseSharing(documentId);
	}
	
	public void increaseLike(int documentId) {
		documentDao.increaseLike(documentId);
	}
	
	public void decreaseLike(int documentId) {
		documentDao.increaseLike(documentId);
	}
	
	public void increaseDislike(int documentId) {
		documentDao.increaseDislike(documentId);
	}
	
	public void decreaseDislike(int documentId) {
		documentDao.increaseDislike(documentId);
	}
	
	public void increaseComment(int documentId) {
		documentDao.increaseComment(documentId);
	}
	
	public void decreaseComment(int documentId) {
		documentDao.decreaseComment(documentId);
	}
	
	public void delete(int documentId) {
		documentDao.delete(documentId);
	}
}

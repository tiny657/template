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
	
	public Document get(Integer documentId) {
		return documentDao.get(documentId);
	}
	
	public String getProviderUesrId(Integer documentId) {
		return documentDao.getProviderUserId(documentId);
	}
	
	public Document getLast() {
		return documentDao.getLast();
	}

	public void increaseSharing(Integer documentId) {
		documentDao.increaseSharing(documentId);
	}
	
	public void decreaseSharing(Integer documentId) {
		documentDao.decreaseSharing(documentId);
	}
	
	public void increaseLike(Integer documentId) {
		documentDao.increaseLike(documentId);
	}
	
	public void decreaseLike(Integer documentId) {
		documentDao.increaseLike(documentId);
	}
	
	public void increaseDislike(Integer documentId) {
		documentDao.increaseDislike(documentId);
	}
	
	public void decreaseDislike(Integer documentId) {
		documentDao.increaseDislike(documentId);
	}
	
	public void increaseComment(Integer documentId) {
		documentDao.increaseComment(documentId);
	}
	
	public void decreaseComment(Integer documentId) {
		documentDao.decreaseComment(documentId);
	}
	
	public void delete(Integer documentId) {
		documentDao.delete(documentId);
	}
}

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

	public void increasePointShare(int documentId) {
		documentDao.increasePointShare(documentId);
	}
	
	public void decreasePointShare(int documentId) {
		documentDao.decreasePointShare(documentId);
	}
	
	public void increasePointLike(int documentId) {
		documentDao.increasePointLike(documentId);
	}
	
	public void decreasePointLike(int documentId) {
		documentDao.increasePointLike(documentId);
	}
	
	public void increasePointDislike(int documentId) {
		documentDao.increasePointDislike(documentId);
	}
	
	public void decreasePointDislike(int documentId) {
		documentDao.increasePointDislike(documentId);
	}
	
	public void increasePointComment(int documentId) {
		documentDao.increasePointComment(documentId);
	}
	
	public void decreasePointComment(int documentId) {
		documentDao.decreasePointComment(documentId);
	}
	
	public void delete(int documentId) {
		documentDao.delete(documentId);
	}
}

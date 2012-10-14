package com.tiny.dao;

import java.util.List;

import com.tiny.document.Document;

public interface DocumentDao {
	public void save(Document document);
	public List<Document> getAll();
	public Integer count();
	public Document get(Integer documentId);
	public String getProviderUserId(Integer documentId);
	public Document getLast();
	public void increaseComment(Integer documentId);
	public void decreaseComment(Integer documentId);
	public void increaseLike(Integer documentId);
	public void decreaseLike(Integer documentId);
	public void increaseDislike(Integer documentId);
	public void decreaseDislike(Integer documentId);
	public void increaseSharing(Integer documentId);
	public void decreaseSharing(Integer documentId);
	public void delete(Integer documentId);
}
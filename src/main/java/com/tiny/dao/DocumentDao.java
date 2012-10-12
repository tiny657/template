package com.tiny.dao;

import java.util.List;

import com.tiny.document.Document;

public interface DocumentDao {
	public void save(Document document);

	public List<Document> getAll();

	public int count();

	public Document get(int documentId);
	
	public Document getLast();

	public void increaseComment(int documentId);

	public void decreaseComment(int documentId);
	
	public void increaseLike(int documentId);
	
	public void decreaseLike(int documentId);
	
	public void increaseDislike(int documentId);
	
	public void decreaseDislike(int documentId);
	
	public void increaseSharing(int documentId);
	
	public void decreaseSharing(int documentId);

	public void delete(int documentId);
}
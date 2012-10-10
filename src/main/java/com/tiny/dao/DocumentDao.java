package com.tiny.dao;

import java.util.List;

import com.tiny.document.Document;

public interface DocumentDao {
	public void save(Document document);

	public List<Document> getAll();

	public int count();

	public Document get(int documentId);
	
	public Document getLast();

	public void update(Document document);

	public void increasePointComment(int documentId);

	public void decreasePointComment(int documentId);
	
	public void increasePointLike(int documentId);
	
	public void decreasePointLike(int documentId);
	
	public void increasePointDislike(int documentId);
	
	public void decreasePointDislike(int documentId);
	
	public void increasePointShare(int documentId);
	
	public void decreasePointShare(int documentId);

	public void delete(int documentId);
}
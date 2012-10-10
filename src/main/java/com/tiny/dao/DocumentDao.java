package com.tiny.dao;

import java.util.List;

import com.tiny.document.Document;

public interface DocumentDao {
	public void save(Document document);

	public List<Document> getAll();

	public Document get(Integer documentId);
	
	public Document getLast();

	public Integer count();

	public void update(Document document);

	public void increaseCountToComment(Integer documentId);

	public void decreaseCountToComment(Integer documentId);
	
	public void increaseCountToLike(Integer documentId);
	
	public void increaseCountToDislike(Integer documentId);
	
	public void increaseCountToShare(Integer documentId);

	public void delete(int documentId);
}
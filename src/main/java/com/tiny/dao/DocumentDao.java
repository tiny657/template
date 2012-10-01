package com.tiny.dao;

import java.util.List;

import com.tiny.document.Document;

public interface DocumentDao {
	public void save(Document document);

	public List<Document> getAll();

	public Document getLast();

	public Integer count();

	public void update(Document document);

	public void delete(int documentId);
}
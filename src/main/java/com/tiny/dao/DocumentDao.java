package com.tiny.dao;

import java.util.List;

import com.tiny.document.Document;

public interface DocumentDao {
	public void saveDocument(Document document);

	public List<Document> getAllDocument();

	public Document getLastDocument();

	public Integer countDocument();

	public void updateDocument(Document document);

	public void deleteDocument(int documentId);
}
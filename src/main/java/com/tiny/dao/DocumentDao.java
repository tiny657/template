package com.tiny.dao;

import java.util.List;

import com.tiny.document.Document;

public interface DocumentDao {
	public void createDocument();
	public void dropDocument();
	
	public void saveDocument(Document document);
	public List<Document> getAllDocument();
	public Document getDocument();
	public Integer countDocument();
	public void updateDocument(Document document);
	public void deleteDocument(int documentId);
}
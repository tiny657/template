package com.tiny.dao;

import java.util.List;

import com.tiny.document.Document;
import com.tiny.user.User;

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
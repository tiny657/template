package com.tiny.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.tiny.document.Document;

public interface DocumentDao {
	@CacheEvict(value = "repository", allEntries = true)
	public void createDocument();

	@CacheEvict(value = "repository", allEntries = true)
	public void dropDocument();

	@CacheEvict(value = "repository", allEntries = true)
	public void saveDocument(Document document);

	@Cacheable(value = "repository")
	public List<Document> getAllDocument();

	@Cacheable(value = "repository")
	public Document getDocument();

	@Cacheable(value = "repository")
	public Integer countDocument();

	@CacheEvict(value = "repository", allEntries = true)
	public void updateDocument(Document document);

	@CacheEvict(value = "repository", allEntries = true)
	public void deleteDocument(int documentId);
}
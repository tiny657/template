package com.tiny.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;
import com.tiny.document.Document;

public class DocumentDaoTest extends CommonTest {
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private DocumentDao documentDao;

	@Before
	public void before() {
		// Because of constraint in Comment.
		commentDao.dropComment();
		documentDao.dropDocument();
		documentDao.createDocument();
	}

	@Test
	public void testInsertDocument() {
		// Given
		int count = documentDao.countDocument();

		// When
		documentDao.saveDocument(getDocument());

		// Then
		assertThat(documentDao.countDocument(), is(count + 1));
	}

	@Test
	public void testUpdateDocument() {
		// Given
		documentDao.saveDocument(getDocument());
		int count = documentDao.countDocument();
		
		// When
		documentDao.updateDocument(getDocument());

		// Then
		assertThat(documentDao.countDocument(), is(count));
	}

	@Test
	public void testGetDocument() {
		// Given
		documentDao.saveDocument(getDocument());

		// When
		Document document = documentDao.getDocument();

		// Then
		assertThat(document.getTitle(), is(getDocument().getTitle()));
	}

	@Test
	public void testDeleteDocument() {
		// Given
		documentDao.saveDocument(getDocument());
		int count = documentDao.countDocument();

		// When
		documentDao.deleteDocument(documentDao.getDocument().getDocumentId());

		// Then
		assertThat(documentDao.countDocument(), is(count - 1));
	}

	private Document getDocument() {
		Document document = new Document();
		document.setTitle("title");
		document.setContent("content");
		document.setUserId("userId");
		document.setIpAddress("112233FF");
		document.setRegDate(new Date());
		document.setLastUpdate(new Date());
		return document;
	}
}

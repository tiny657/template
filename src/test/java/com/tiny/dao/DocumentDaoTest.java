package com.tiny.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;
import com.tiny.document.Document;

public class DocumentDaoTest extends CommonTest {
	@Autowired
	private DocumentDao documentDao;

	@Test
	public void testInsertDocument() {
		// Given
		int count = documentDao.count();

		// When
		documentDao.save(getDocument());

		// Then
		assertThat(documentDao.count(), is(count + 1));
	}

	@Test
	public void testUpdateDocument() {
		// Given
		documentDao.save(getDocument());
		int count = documentDao.count();

		// When
		documentDao.update(getDocument());

		// Then
		assertThat(documentDao.count(), is(count));
	}

	@Test
	public void testGetDocument() {
		// Given
		documentDao.save(getDocument());

		// When
		Document document = documentDao.getLast();

		// Then
		assertThat(document.getContent(), is(getDocument().getContent()));
	}

	@Test
	public void testDeleteDocument() {
		// Given
		documentDao.save(getDocument());
		int count = documentDao.count();

		// When
		documentDao.delete(documentDao.getLast().getDocumentId());

		// Then
		assertThat(documentDao.count(), is(count - 1));
	}

	private Document getDocument() {
		Document document = new Document();
		document.setContent("content");
		document.setProviderUserId("userId");
		document.setIpAddress("127.0.0.1");
		document.setRegDate(new Date());
		return document;
	}
}

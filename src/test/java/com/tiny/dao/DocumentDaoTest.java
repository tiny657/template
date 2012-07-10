package com.tiny.dao;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;
import com.tiny.document.Document;

public class DocumentDaoTest extends CommonTest {
	@Autowired
	DocumentDao documentDao;

	@Before
	public void before() {
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
		documentDao.updateDocument(documentDao.getDocument());

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

	public Document getDocument() {
		return new Document(10, false, "title", false, "", "content", 1, 2, 3, 4, "userId", "nick", "11223344", "tags");
	}
}

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
		int count = documentDao.countDocument();
		documentDao.saveDocument(getDocument());
		assertThat(documentDao.countDocument(), is(count + 1));
	}

	@Test
	public void testUpdateDocument() {
		documentDao.saveDocument(getDocument());
		int count = documentDao.countDocument();

		documentDao.updateDocument(documentDao.getDocument());
		assertThat(documentDao.countDocument(), is(count));
	}

	@Test
	public void testGetDocument() {
		documentDao.saveDocument(getDocument());
		Document document = documentDao.getDocument();
		assertThat(document.getTitle(), is(getDocument().getTitle()));
	}

	@Test
	public void testDeleteDocument() {
		documentDao.saveDocument(getDocument());
		int count = documentDao.countDocument();

		documentDao.deleteDocument(documentDao.getDocument().getDocumentId());
		assertThat(documentDao.countDocument(), is(count - 1));
	}
	
	public Document getDocument() {
		return new Document(100, false, "title", false, "", "content", 1, 2, 3, 4, "userId", "nick", "11223344", "tags");
	}
}

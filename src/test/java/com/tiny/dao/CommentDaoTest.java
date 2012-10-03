package com.tiny.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tiny.comment.Comment;
import com.tiny.common.CommonTest;
import com.tiny.document.Document;

public class CommentDaoTest extends CommonTest {
	@Autowired
	private CommentDao commentDao;

	@Autowired
	private DocumentDao documentDao;

	@Test
	public void save() {
		// Given
		Document document = createDocument();
		int count = commentDao.count();

		// When
		commentDao.save(createComment(document.getDocumentId()));

		// Then
		assertThat(commentDao.count(), is(count + 1));
	}

	@Test
	public void get() {
		// Given
		Document document = createDocument();
		commentDao.save(createComment(document.getDocumentId()));

		// When
		List<Comment> comments = commentDao.get(document.getDocumentId());

		// Then
		assertThat(comments.get(0).getProviderUserId(), is(createComment(document.getDocumentId()).getProviderUserId()));
	}

	@Test
	public void update() {
		// Given
		Document document = createDocument();
		commentDao.save(createComment(document.getDocumentId()));
		int count = commentDao.count();

		// When
		commentDao.update(createComment(document.getDocumentId()));

		// Then
		assertThat(commentDao.count(), is(count));
	}

	@Test
	public void delete() {
		// Given
		Document document = createDocument();
		commentDao.save(createComment(document.getDocumentId()));
		int count = commentDao.count();

		// When
		commentDao.delete(commentDao.getLastCommentId());

		// Then
		assertThat(commentDao.count(), is(count - 1));
	}

	@Test
	public void deleteWithDocumentId() {
		// Given
		Document document = createDocument();
		commentDao.save(createComment(document.getDocumentId()));
		commentDao.save(createComment(document.getDocumentId()));
		int count = commentDao.count();

		// When
		commentDao.deleteWithDocumentId(document.getDocumentId());

		// Then
		assertThat(commentDao.count(), is(count - 2));
	}

	private Comment createComment(int documentId) {
		Comment comment = new Comment();
		comment.setDocumentId(documentId);
		comment.setContent("content");
		comment.setProviderUserId("providerUserId");
		comment.setRegDate(new Date());
		return comment;
	}

	@Transactional
	private Document createDocument() {
		Document document = new Document();
		document.setContent("content");
		document.setProviderUserId("providerUserId");
		document.setIpAddress("127.0.0.1");
		document.setRegDate(new Date());
		documentDao.save(document);
		return documentDao.getLast();
	}
}
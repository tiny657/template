package com.tiny.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.comment.Comment;
import com.tiny.common.CommonTest;
import com.tiny.document.Document;

public class CommentDaoTest extends CommonTest {
	@Autowired
	private CommentDao commentDao;

	@Autowired
	private DocumentDao documentDao;

	@Before
	public void before() {
		commentDao.dropComment();
		commentDao.createComment();
	}

	@Test
	public void testInsertComment() {
		// Given
		documentDao.saveDocument(getDocument());
		Document doc = documentDao.getDocument();
		int count = commentDao.countComment();

		// When
		commentDao.saveComment(getComment(doc.getDocumentId()));

		// Then
		assertThat(commentDao.countComment(), is(count + 1));
	}

	@Test
	public void testUpdateComment() {
		// Given
		documentDao.saveDocument(getDocument());
		Document doc = documentDao.getDocument();
		commentDao.saveComment(getComment(doc.getDocumentId()));
		int count = commentDao.countComment();

		// When
		commentDao.updateComment(getComment(doc.getDocumentId()));

		// Then
		assertThat(commentDao.countComment(), is(count));
	}

	@Test
	public void testGetComment() {
		// Given
		documentDao.saveDocument(getDocument());
		Document doc = documentDao.getDocument();
		commentDao.saveComment(getComment(doc.getDocumentId()));

		// When
		Comment comment = commentDao.getComment();

		// Then
		assertThat(comment.getUserId(), is(getComment(doc.getDocumentId()).getUserId()));
	}

	@Test
	public void testDeleteComment() {
		// Given
		documentDao.saveDocument(getDocument());
		Document doc = documentDao.getDocument();
		commentDao.saveComment(getComment(doc.getDocumentId()));
		int count = commentDao.countComment();

		// When
		commentDao.deleteComment(commentDao.getComment().getCommentId());

		// Then
		assertThat(commentDao.countComment(), is(count - 1));
	}

	public Comment getComment(int documentId) {
		Comment comment = new Comment();
		comment.setDocumentId(documentId);
		comment.setContent("content");
		comment.setUserId("userId");
		comment.setRegDate(new Date());
		return comment;
	}

	public Document getDocument() {
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
package com.tiny.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

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
	public void setUp() {
		documentDao.saveDocument(getDocument());
	}

	@Test
	public void testInsertComment() {
		// Given
		Document doc = documentDao.getLastDocument();
		int count = commentDao.countComment();

		// When
		commentDao.saveComment(getComment(doc.getDocumentId()));

		// Then
		assertThat(commentDao.countComment(), is(count + 1));
	}

	@Test
	public void testGetComments() {
		// Given
		Document doc = documentDao.getLastDocument();
		commentDao.saveComment(getComment(doc.getDocumentId()));

		// When
		List<Comment> comments = commentDao.getComments(commentDao.getLastCommentId());

		// Then
		assertThat(comments.get(0).getUserId(), is(getComment(doc.getDocumentId()).getUserId()));
	}

	@Test
	public void testUpdateComment() {
		// Given
		Document doc = documentDao.getLastDocument();
		commentDao.saveComment(getComment(doc.getDocumentId()));
		int count = commentDao.countComment();

		// When
		commentDao.updateComment(getComment(doc.getDocumentId()));

		// Then
		assertThat(commentDao.countComment(), is(count));
	}

	@Test
	public void testDeleteComment() {
		// Given
		Document doc = documentDao.getLastDocument();
		commentDao.saveComment(getComment(doc.getDocumentId()));
		int count = commentDao.countComment();
		
		// When
		commentDao.deleteComment(commentDao.getLastCommentId());

		// Then
		assertThat(commentDao.countComment(), is(count - 1));
	}

	@Test
	public void testDeleteCommentWithDocumentId() {
		// Given
		Document doc = documentDao.getLastDocument();
		commentDao.saveComment(getComment(doc.getDocumentId()));
		commentDao.saveComment(getComment(doc.getDocumentId()));
		int count = commentDao.countComment();

		// When
		commentDao.deleteCommentWithDocumentId(doc.getDocumentId());

		// Then
		assertThat(commentDao.countComment(), is(count - 2));
	}

	private Comment getComment(int documentId) {
		Comment comment = new Comment();
		comment.setDocumentId(documentId);
		comment.setContent("content");
		comment.setUserId("userId");
		comment.setRegDate(new Date());
		return comment;
	}

	private Document getDocument() {
		Document document = new Document();
		document.setContent("content");
		document.setUserId("userId");
		document.setIpAddress("127.0.0.1");
		document.setRegDate(new Date());
		document.setLastUpdate(new Date());
		return document;
	}
}
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
	
	private Document document;

	@Transactional
	@Before
	public void setUp() {
		documentDao.saveDocument(getDocument());
		document = documentDao.getLastDocument();
	}

	@Test
	public void testInsertComment() {
		// Given
		int count = commentDao.countComment();

		// When
		commentDao.saveComment(getComment(document.getDocumentId()));

		// Then
		assertThat(commentDao.countComment(), is(count + 1));
	}
	
	@Test
	public void testGetComments() {
		// Given
		commentDao.saveComment(getComment(document.getDocumentId()));
		
		// When
		List<Comment> comments = commentDao.getComments(document.getDocumentId());

		// Then
		assertThat(comments.get(0).getUserId(), is(getComment(document.getDocumentId()).getUserId()));
	}

	@Test
	public void testUpdateComment() {
		// Given
		commentDao.saveComment(getComment(document.getDocumentId()));
		int count = commentDao.countComment();

		// When
		commentDao.updateComment(getComment(document.getDocumentId()));

		// Then
		assertThat(commentDao.countComment(), is(count));
	}

	@Test
	public void testDeleteComment() {
		// Given
		commentDao.saveComment(getComment(document.getDocumentId()));
		int count = commentDao.countComment();
		
		// When
		commentDao.deleteComment(commentDao.getLastCommentId());

		// Then
		assertThat(commentDao.countComment(), is(count - 1));
	}

	@Test
	public void testDeleteCommentWithDocumentId() {
		// Given
		commentDao.saveComment(getComment(document.getDocumentId()));
		commentDao.saveComment(getComment(document.getDocumentId()));
		int count = commentDao.countComment();

		// When
		commentDao.deleteCommentWithDocumentId(document.getDocumentId());

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
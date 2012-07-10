package com.tiny.dao;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
		return new Comment(documentId, false, false, "content", "userId");
	}

	public Document getDocument() {
		return new Document(10, false, "title", false, "", "content", 1, 2, 3, 4, "userId", "nick", "11223344", "tags");
	}
}
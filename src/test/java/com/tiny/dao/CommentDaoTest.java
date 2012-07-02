package com.tiny.dao;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;
import com.tiny.comment.Comment;

public class CommentDaoTest extends CommonTest {
	@Autowired
	CommentDao commentDao;

	@Before
	public void before() {
		commentDao.createComment();
	}

	@Test
	public void testInsertComment() {
//		int count = commentDao.countComment();
//		commentDao.saveComment(getComment());
//		assertThat(commentDao.countComment(), is(count + 1));
	}

	@Test
	public void testUpdateComment() {
//		commentDao.saveComment(getComment());
//		int count = commentDao.countComment();
//
//		commentDao.updateComment(commentDao.getComment());
//		assertThat(commentDao.countComment(), is(count));
	}

	@Test
	public void testGetComment() {
//		commentDao.saveComment(getComment());
//		Comment comment = commentDao.getComment();
//		assertThat(comment.getTitle(), is(getComment().getTitle()));
	}

	@Test
	public void testDeleteComment() {
//		commentDao.saveComment(getComment());
//		int count = commentDao.countComment();
//
//		commentDao.deleteComment(commentDao.getComment().getCommentId());
//		assertThat(commentDao.countComment(), is(count - 1));
	}
	
	public Comment getComment() {
		return new Comment(100, false, false, "content", "userId");
	}
}

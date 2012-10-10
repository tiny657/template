package com.tiny.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tiny.comment.Comment;
import com.tiny.dao.CommentDao;

@Repository
public class CommentRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentRepository.class);

	@Autowired
	private CommentDao commentDao;

	public void save(Comment comment) {
		commentDao.save(comment);
	}
	
	public int countWithDocumentId(int documentId) {
		return commentDao.countWithDocumentId(documentId);
	}

	public List<Comment> get(int documentId) {
		return commentDao.get(documentId);
	}
	
	public Comment getCommentId(int commentId) {
		return commentDao.getCommentId(commentId);
	}
	
	public Comment getLast() {
		return commentDao.getLast();
	}

	public void deleteWithDocumentId(int documentId) {
		commentDao.deleteWithDocumentId(documentId);
	}
	
	public void delete(int commentId) {
		commentDao.delete(commentId);
	}
}
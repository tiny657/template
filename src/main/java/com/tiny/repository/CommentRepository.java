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
	
	public Integer countByDocumentId(Integer documentId) {
		return commentDao.countByDocumentId(documentId);
	}

	public List<Comment> get(Integer documentId) {
		return commentDao.get(documentId);
	}
	
	public Comment getCommentId(Integer commentId) {
		return commentDao.getCommentId(commentId);
	}
	
	public Comment getLast() {
		return commentDao.getLast();
	}

	public void deleteWithDocumentId(Integer documentId) {
		commentDao.deleteWithDocumentId(documentId);
	}
	
	public void delete(Integer commentId) {
		commentDao.delete(commentId);
	}
}
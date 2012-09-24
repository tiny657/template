package com.tiny.service;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiny.comment.Comment;
import com.tiny.common.util.XssFilter;
import com.tiny.repository.CommentRepository;

@Service
public class CommentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentService.class);

	@Autowired
	private XssFilter xssFilter;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private FacebookService facebookService;

	public void save(Comment comment) {
		comment.setUserId(facebookService.getId());
		comment.setContent(xssFilter.doFilter(comment.getContent()));
		comment.setRegDate(new Date(java.util.Calendar.getInstance().getTimeInMillis()));
		commentRepository.save(comment);
	}

	public List<Comment> getComments(Integer documentId) {
		List<Comment> comments = commentRepository.getComments(documentId);
		for (Comment comment : comments) {
			comment.setContent(comment.getContent().replace("\r\n", "<br>").replace(" ", "&nbsp"));
		}

		return comments;
	}

	public void deleteWithDocumentId(Integer documentId) {
		commentRepository.deleteWithDocumentId(documentId);
	}
	
	public void delete(Integer commentId) {
		commentRepository.delete(commentId);
	}
}

package com.tiny.service;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiny.comment.Comment;
import com.tiny.common.util.XssFilter;
import com.tiny.repository.CommentRepository;
import com.tiny.repository.MemberRepository;
import com.tiny.repository.UserConnectionRepository;
import com.tiny.social.SecurityContext;

@Service
public class CommentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentService.class);

	@Autowired
	private XssFilter xssFilter;

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private FacebookService facebookService;
	
	@Autowired
	private UserConnectionRepository userConnectionRepository;

	public void save(Comment comment) {
		String providerUserId = userConnectionRepository.getProviderUserId(SecurityContext.getCurrentUser().getId());
		comment.setProviderUserId(providerUserId);
		comment.setName(memberRepository.getName(providerUserId));
		comment.setContent(xssFilter.doFilter(comment.getContent()));
		comment.setRegDate(new Date(java.util.Calendar.getInstance().getTimeInMillis()));
		commentRepository.save(comment);
	}
	
	@Transactional
	public Comment saveAndGet(Comment comment) {
		save(comment);
		return commentRepository.getLast();
	}

	public List<Comment> get(int documentId) {
		List<Comment> comments = commentRepository.get(documentId);
		for (Comment comment : comments) {
			comment.setContent(comment.getContent().replace("\r\n", "<br>").replace(" ", "&nbsp"));
		}

		return comments;
	}

	public Comment getCommentId(int commentId) {
		return commentRepository.getCommentId(commentId);
	}

	public void deleteWithDocumentId(int documentId) {
		commentRepository.deleteWithDocumentId(documentId);
	}
	
	public void delete(int commentId) {
		commentRepository.delete(commentId);
	}
}
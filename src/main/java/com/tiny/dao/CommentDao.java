package com.tiny.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.tiny.comment.Comment;

public interface CommentDao {
	public void createComment();

	public void dropComment();

	public void saveComment(Comment comment);

	public List<Comment> getAllComment();

	public Comment getComment();

	public Integer countComment();

	public void updateComment(Comment comment);

	public void deleteComment(int commentId);
}
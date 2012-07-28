package com.tiny.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.tiny.comment.Comment;

public interface CommentDao {
	@CacheEvict(value = "repository", allEntries = true)
	public void createComment();

	@CacheEvict(value = "repository", allEntries = true)
	public void dropComment();

	@CacheEvict(value = "repository", allEntries = true)
	public void saveComment(Comment comment);

	@Cacheable(value = "repository")
	public List<Comment> getAllComment();

	@Cacheable(value = "repository")
	public Comment getComment();

	@Cacheable(value = "repository")
	public Integer countComment();

	@CacheEvict(value = "repository", allEntries = true)
	public void updateComment(Comment comment);

	@CacheEvict(value = "repository", allEntries = true)
	public void deleteComment(int commentId);
}
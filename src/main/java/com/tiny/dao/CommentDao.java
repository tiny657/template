package com.tiny.dao;

import java.util.List;

import com.tiny.comment.Comment;

public interface CommentDao {
	public void save(Comment comment);

	public List<Comment> get(Integer documentId);
	
	public Integer getLastCommentId();

	public Integer count();

	public void update(Comment comment);

	public void delete(int commentId);
	
	public void deleteWithDocumentId(int documentId);
}
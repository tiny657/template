package com.tiny.dao;

import java.util.List;

import com.tiny.comment.Comment;

public interface CommentDao {
	public void save(Comment comment);
	public Integer count();
	public Integer countByDocumentId(Integer documentId);
	public List<Comment> get(Integer documentId);
	public Comment getCommentId(Integer commentId);
	public Comment getLast();
	public Integer getLastCommentId();
	public void update(Comment comment);
	public void delete(Integer commentId);
	public void deleteWithDocumentId(Integer documentId);
}
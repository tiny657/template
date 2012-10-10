package com.tiny.dao;

import java.util.List;

import com.tiny.comment.Comment;

public interface CommentDao {
	public void save(Comment comment);
	
	public int count();
	
	public int countWithDocumentId(int documentId);

	public List<Comment> get(int documentId);

	public Comment getCommentId(int commentId);
	
	public Comment getLast();
	
	public int getLastCommentId();

	public void update(Comment comment);

	public void delete(int commentId);
	
	public void deleteWithDocumentId(int documentId);
}
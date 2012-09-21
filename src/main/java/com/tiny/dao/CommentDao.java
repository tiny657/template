package com.tiny.dao;

import java.util.List;

import com.tiny.comment.Comment;

public interface CommentDao {
	public void saveComment(Comment comment);

	public List<Comment> getComments(Integer documentId);
	
	public Integer getLastCommentId();

	public Integer countComment();

	public void updateComment(Comment comment);

	public void deleteComment(int commentId);
	
	public void deleteCommentWithDocumentId(int documentId);
}
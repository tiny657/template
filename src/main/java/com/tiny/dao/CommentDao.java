package com.tiny.dao;

import java.util.List;

import com.tiny.comment.Comment;
import com.tiny.user.User;

public interface CommentDao {
	public void createComment();
	public void dropComment();
	
	public void saveComment(Comment comment);
	public List<Comment> getAllComment();
	public User getComment(int commentId);
	public Integer countComment();
	public void updateComment(Comment comment);
	public void deleteComment(int commentId);
}
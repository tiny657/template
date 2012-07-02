package com.tiny.comment;

import lombok.Data;

@Data
public class Comment {
	// Primary Key
	int commentId;
	// Foreign Key
	int documentId;
	boolean like;
	boolean dislike;
	String content;
	String userId;
	
	public Comment() {
	}
	
	public Comment(int documentId, boolean like, boolean dislike, String content, String userId) {
		this.documentId = documentId;
		this.like = like;
		this.dislike = dislike;
		this.content = content;
		this.userId = userId;
	}
}

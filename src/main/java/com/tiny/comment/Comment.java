package com.tiny.comment;

import lombok.Data;

@Data
public class Comment {
	// Primary Key
	int commentId;
	// Foreign Key
	int documentId;
	boolean likeCount;
	boolean dislikeCount;
	String content;
	String userId;
	
	public Comment() {
	}
	
	public Comment(int documentId, boolean likeCount, boolean dislikeCount, String content, String userId) {
		this.documentId = documentId;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
		this.content = content;
		this.userId = userId;
	}
}

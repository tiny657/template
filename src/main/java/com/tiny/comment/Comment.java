package com.tiny.comment;

import lombok.Data;

@Data
public class Comment {
	// Primary Key
	private int commentId;
	// Foreign Key
	private int documentId;
	private boolean likeCount;
	private boolean dislikeCount;
	private String content;
	private String userId;

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

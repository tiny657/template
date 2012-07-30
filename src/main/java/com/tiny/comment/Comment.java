package com.tiny.comment;

import java.util.Date;

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
	private Date regDate;
}

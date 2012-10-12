package com.tiny.comment;

import java.util.Date;

import lombok.Data;

@Data
public class Comment {
	private int commentId;
	private int documentId;
	private String content;
	private String providerUserId;
	private String name;
	private Date regDate;
}

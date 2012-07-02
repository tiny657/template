package com.tiny.document;

import java.util.Date;

import lombok.Data;

@Data
public class Document {
	// Primary Key
	int documentId;
	int point;
	boolean isNotice;
	// varchar(250)
	String title;
	boolean titleBold;
	// varchar(7)
	String titleColor;
	// Text
	String content;
	int likeCount;
	int dislikeCount;
	int commentCount;
	int shareCount;
	// varchar(12)
	String userId;
	// varchar(20)
	String nickName;
	// char(8)
	String ipAddress;
	// Text
	String tags;
	Date regDate;
	Date lastUpdate;
	
	public Document() {
	}
	
	public Document(int point, boolean isNotice, String title, boolean titleBold, String titleColor, String content,
			int likeCount, int dislikeCount, int commentCount, int shareCount, String userId, String nickName,
			String ipAddress, String tags) {
		this.point = point;
		this.isNotice = isNotice;
		this.title = title;
		this.titleBold = titleBold;
		this.titleColor = titleColor;
		this.content = content;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
		this.commentCount = commentCount;
		this.shareCount = shareCount;
		this.userId = userId;
		this.nickName = nickName;
		this.ipAddress = ipAddress;
		this.tags = tags;
	}
}
package com.tiny.document;

import java.util.Date;

import lombok.Data;

@Data
public class Document {
	// Primary Key
	private int documentId;
	private int point;
	private boolean isNotice;
	// varchar(250)
	private String title;
	private boolean titleBold;
	// varchar(7)
	private String titleColor;
	// Text
	private String content;
	private int likeCount;
	private int dislikeCount;
	private int commentCount;
	private int shareCount;
	// varchar(12)
	private String userId;
	// varchar(20)
	private String nickName;
	// char(8)
	private String ipAddress;
	// Text
	private String tags;
	private Date regDate;
	private Date lastUpdate;

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
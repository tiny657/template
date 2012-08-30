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

	public void setIpAddress(String ipAddress) {
		String[] split = ipAddress.split("\\.");
		if (split.length == 4) {
			this.ipAddress = String.format("%02x%02x%02x%02x", Integer.parseInt(split[0]), Integer.parseInt(split[1]),
					Integer.parseInt(split[2]), Integer.parseInt(split[3]));
		}
	}
}
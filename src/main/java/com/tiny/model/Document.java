package com.tiny.model;

import java.util.Date;

import lombok.Data;

@Data
public class Document {
	private Integer documentId;
	private String content;
	private Integer point;
	private Integer like;
	private Integer dislike;
	private Integer comment;
	private Integer sharing;
	private String providerUserId;
	private String name;
	private String ipAddress;
	private Date regDate;
	
	// from Like
	private Boolean hasMyLike;
	private Boolean hasMyDislike;

	public void setIpAddress(String ipAddress) {
		String[] split = ipAddress.split("\\.");
		if (split.length == 4) {
			this.ipAddress = String.format("%02x%02x%02x%02x", Integer.parseInt(split[0]), Integer.parseInt(split[1]),
					Integer.parseInt(split[2]), Integer.parseInt(split[3]));
		}
	}
}
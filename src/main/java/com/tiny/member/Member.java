package com.tiny.member;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	private String providerUserId;
	private String name;
	private boolean gender;
	private String email;
	private int level;
	private int point;
	private int pointDocument;
	private int pointComment;
	private int pointBeCommented;
	private int pointLike;
	private int pointBeLiked;
	private int pointDislike;
	private int pointBeDisliked;
	private int pointShare;
	private int pointBeShared;
	private String locale;
	private Date regDate;
	private Date lastLogin;
}
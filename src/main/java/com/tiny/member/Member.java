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
	private int doc;
	private int comment;
	private int commentOnMyDoc;
	private int like;
	private int likeOnMyDoc;
	private int dislike;
	private int dislikeOnMyDoc;
	private int sharing;
	private int sharingOfMyDoc;
	private String locale;
	private Date regDate;
	private Date lastLoginDate;
}
package com.tiny.member;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	private int memberId;
	private String providerUserId;
	private String email;
	private String name;
	private int point;
	private int documentCount;
	private int commentCount;
	private int likeCount;
	private int dislikeCount;
	private boolean isAdmin;
	private Date regDate;
	private Date lastLogin;
}
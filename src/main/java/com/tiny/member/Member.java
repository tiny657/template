package com.tiny.member;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	// Primary Key
	private int memberId;
	// varchar(12)
	private String userId;
	// Unique, varchar(30)
	private String email;
	// varchar(20)
	private String nickName;
	// char(41)
	private String password;
	private Date birthday;
	// Text
	private String description;
	private int point;
	private int documentCount;
	private int commentCount;
	private int likeCount;
	private int dislikeCount;
	private boolean isAdmin;
	private boolean allowMailing;
	private Date regDate;
	private Date lastLogin;
}
package com.tiny.member;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	// Primary Key
	int memberId;
	// varchar(12)
	String userId;
	// Unique, varchar(30)
	String email;
	// varchar(20)
	String nickName;
	// char(41)
	String password;
	Date birthday;
	// Text
	String description;
	int point;
	int documentCount;
	int commentCount;
	int likeCount;
	int dislikeCount;
	boolean isAdmin;
	boolean allowMailing;
	Date regDate;
	Date lastLogin;

	public Member() {
	}

	public Member(String userId, String email, String nickName, String password, Date birthday, String description,
			int point, int documentCount, int commentCount, int likeCount, int dislikeCount, boolean isAdmin,
			boolean allowMailing) {
		this.userId = userId;
		this.email = email;
		this.nickName = nickName;
		this.password = password;
		this.birthday = birthday;
		this.description = description;
		this.point = point;
		this.documentCount = documentCount;
		this.commentCount = commentCount;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
		this.isAdmin = isAdmin;
		this.allowMailing = allowMailing;
	}
}
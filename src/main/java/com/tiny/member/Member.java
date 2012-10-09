package com.tiny.member;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	private String providerUserId;
	private String email;
	private String name;
	// female : 0, male : 1
	private boolean gender;
	private int point;
	private int countDocument;
	private int countToComment;
	private int countToBeCommented;
	private int countToLike;
	private int countToBeLiked;
	private int countToDislike;
	private int countToBeDisliked;
	private int countToShare;
	private int documentCount;
	private int commentCount;
	private int likeCount;
	private int dislikeCount;
	private String locale;
	private boolean isAdmin;
	private Date regDate;
	private Date lastLogin;
}
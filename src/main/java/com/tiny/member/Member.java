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
	private int countToDocument;
	private int countToComment;
	private int countToBeCommented;
	private int countToLike;
	private int countToBeLiked;
	private int countToDislike;
	private int countToBeDisliked;
	private int countToShare;
	private int countToBeShared;
	private String locale;
	private Date regDate;
	private Date lastLogin;
}
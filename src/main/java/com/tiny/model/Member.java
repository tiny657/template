package com.tiny.model;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	private String providerUserId;
	private String name;
	private boolean gender;
	private String email;
	private Integer level;
	private Integer point;
	private Integer doc;
	private Integer comment;
	private Integer commentOnMyDoc;
	private Integer like;
	private Integer likeOnMyDoc;
	private Integer dislike;
	private Integer dislikeOnMyDoc;
	private Integer sharing;
	private Integer sharingOfMyDoc;
	private Integer chanceToDoc;
	private Integer chanceToComment;
	private Integer chanceToLike;
	private Integer chanceToDislike;
	private String locale;
	private Date regDate;
	private Date lastLoginDate;
}
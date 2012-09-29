package com.tiny.member;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	private int memberId;
	private String userId;
	private String email;
	private String name;
	private String password;
	private Date birthday;
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
	private byte[] profileImage;

	public void setProfileImage(byte[] image) {
		profileImage = new byte[image.length];
		for (int i = 0; i < image.length; i++) {
			profileImage[i] = image[i];
		}
	}
}
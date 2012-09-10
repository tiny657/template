package com.tiny.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;

import com.tiny.member.Member;

@Service
public class MemberService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

	@Autowired
	private Facebook facebook;

	public Member getMember(FacebookProfile profile) {
		Member member = new Member();
		member.setNickName(profile.getName());
		member.setEmail(profile.getEmail());
		return member;
	}
	
	public FacebookProfile getProfile() {
		return facebook.userOperations().getUserProfile();
	}
	
	public byte[] getProfileImage() {
		return facebook.userOperations().getUserProfileImage();
	}
}

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

	public Member getMember() {
		Member member = new Member();
		FacebookProfile profile = facebook.userOperations().getUserProfile();
		member.setProfileImage(facebook.userOperations().getUserProfileImage());
		member.setNickName(profile.getName());
		member.setEmail(profile.getEmail());
		return member;
	}
}

package com.tiny.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;

import com.tiny.member.Member;

@Service
public class MemberService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);
	
	public Member getMember(FacebookProfile facebookProfile) {
		Member member = new Member();
		member.setUserId(facebookProfile.getId());
		member.setName(facebookProfile.getName());
		member.setEmail(facebookProfile.getEmail());
		return member;
	}
}

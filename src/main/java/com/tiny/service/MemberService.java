package com.tiny.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;

import com.tiny.member.Member;
import com.tiny.repository.MemberRepository;
import com.tiny.repository.UserConnectionRepository;

@Service
public class MemberService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private FacebookService facebookService;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private UserConnectionRepository userConnectionRepository;
	
	public Member get(String userId) {
		Member member = memberRepository.get(userConnectionRepository.getProviderUserId(userId));
		if (member == null) {
			member = save();
		}
		
		return member;
	}
	
	public Member save() {
		FacebookProfile facebookProfile = facebookService.getProfile();
		Member member = new Member();
		member.setProviderUserId(facebookProfile.getId());
		member.setName(facebookProfile.getName());
		member.setGender(facebookProfile.getGender().equals("male"));
		member.setEmail(facebookProfile.getEmail());
		member.setLocale(facebookProfile.getLocale().toString());
		memberRepository.save(member);
		return member;
	}
	
	public void updateLastLogin(String userId) {
		memberRepository.updateLastLogin(userId);
	}
}
package com.tiny.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;

import com.tiny.member.Member;
import com.tiny.repository.MemberRepository;
import com.tiny.repository.UserConnectionRepository;
import com.tiny.social.SecurityContext;

@Service
public class MemberService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private FacebookService facebookService;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private UserConnectionRepository userConnectionRepository;
	
	public boolean isExisted(String userId) {
		boolean isExisted = true;
		Member member = memberRepository.get(userConnectionRepository.getProviderUserId(userId));
		if (member == null) {
			isExisted = false;
		}
		return isExisted;
	}
	
	public Member saveAndGet() {
		FacebookProfile facebookProfile = facebookService.getProfile();
		Member member = new Member();
		member.setProviderUserId(facebookProfile.getId());
		member.setName(facebookProfile.getName());
		member.setGender(facebookProfile.getGender().equals("male"));
		member.setEmail(facebookProfile.getEmail());
		member.setLocale(facebookProfile.getLocale().getCountry());
		memberRepository.save(member);
		return member;
	}
	
	public Member get(String userId) {
		Member member = memberRepository.get(userConnectionRepository.getProviderUserId(userId));
		if (member == null) {
			member = saveAndGet();
		}
		
		return member;
	}
	
	public Member getByProviderUserId(String providerUserId) {
		Member member = memberRepository.get(providerUserId);
		if (member == null) {
			member = saveAndGet();
		}
		
		return member;
	}
	
	public void updateName(String name) {
		memberRepository.updateName(SecurityContext.getCurrentUser().getId(), name);
	}
	
	public void updateLastLoginTime(String userId) {
		memberRepository.updateLastLoginDate(userId);
	}
}
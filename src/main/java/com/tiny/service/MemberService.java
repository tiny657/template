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
	
	public void updateName(String name) {
		memberRepository.updateName(facebookService.getProfile().getId(), name);
	}
	
	public void increaseCountToDocument(String providerUserId) {
		memberRepository.increaseCountToDocument(providerUserId);
	}

	public void decreaseCountToDocument(String providerUserId) {
		memberRepository.decreaseCountToDocument(providerUserId);
	}
	
	public void increaseCountToShare(String userId) {
		memberRepository.increaseCountToShare(userId);
	}

	public void increaseCountToBeShared(String providerUserId) {
		memberRepository.increaseCountToBeShared(providerUserId);
	}
	
	public void increaseCountToLike(String userId) {
		memberRepository.increaseCountToLike(userId);
	}
	
	public void increaseCountToBeLiked(String providerUserId) {
		memberRepository.increaseCountToBeLiked(providerUserId);
	}
	
	public void increaseCountToDislike(String userId) {
		memberRepository.increaseCountToDislike(userId);
	}
	
	public void increaseCountToBeDisliked(String providerUserId) {
		memberRepository.increaseCountToBeDisliked(providerUserId);
	}
	
	public void increaseCountToComment(String providerUserId) {
		memberRepository.increaseCountToComment(providerUserId);
	}

	public void decreaseCountToComment(String providerUserId) {
		memberRepository.decreaseCountToComment(providerUserId);
	}
	
	public void increaseCountToBeCommented(String providerUserId) {
		memberRepository.increaseCountToBeCommented(providerUserId);
	}
	public void decreaseCountToBeCommented(String providerUserId) {
		memberRepository.decreaseCountToBeCommented(providerUserId);
	}
	
	public void updateLastLoginTime(String userId) {
		memberRepository.updateLastLoginTime(userId);
	}
}
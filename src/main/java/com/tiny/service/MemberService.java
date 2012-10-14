package com.tiny.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;

import com.tiny.member.Member;
import com.tiny.repository.DocumentRepository;
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

	public void save() {
		FacebookProfile facebookProfile = facebookService.getProfile();
		Member member = new Member();
		member.setProviderUserId(facebookProfile.getId());
		member.setName(facebookProfile.getName());
		member.setGender(facebookProfile.getGender().equals("male"));
		member.setEmail(facebookProfile.getEmail());
		member.setLocale(facebookProfile.getLocale().getCountry());
		memberRepository.save(member);
	}
	
	public Member get(String userId) {
		Member member = memberRepository.get(userId);
		if (member == null) {
			save();
			member = memberRepository.get(userId);
		}

		return member;
	}

	public Member getByProviderUserId(String providerUserId) {
		Member member = memberRepository.getByProviderUserId(providerUserId);
		if (member == null) {
			save();
			member = memberRepository.getByProviderUserId(providerUserId);
		}

		return member;
	}

	public boolean isExisted() {
		boolean isExisted = true;
		Member member = memberRepository.get(SecurityContext.getCurrentUser().getId());
		if (member == null) {
			isExisted = false;
		}
		return isExisted;
	}

	public boolean isChanceToDoc() {
		return memberRepository.getChanceToDoc(SecurityContext.getCurrentUser().getId()) > 0;
	}

	public boolean isChanceToComment() {
		return memberRepository.getChanceToComment(SecurityContext.getCurrentUser().getId()) > 0;
	}

	public boolean isChanceToLike() {
		return memberRepository.getChanceToLike(SecurityContext.getCurrentUser().getId()) > 0;
	}

	public boolean isChanceToDislike() {
		return memberRepository.getChanceToDislike(SecurityContext.getCurrentUser().getId()) > 0;
	}

	public void updateName(String name) {
		memberRepository.updateName(SecurityContext.getCurrentUser().getId(), name);
	}

	public void updateLastLoginTime(String userId) {
		memberRepository.updateLastLoginDate(userId);
	}
	
	public void increaseChanceToDoc(String providerUserId) {
		memberRepository.increaseChanceToDoc(providerUserId);
	}
	
	public void decreaseChanceToDoc(String providerUserId) {
		memberRepository.decreaseChanceToDoc(providerUserId);
	}
	
	public void increaseChanceToComment(String providerUserId) {
		memberRepository.increaseChanceToComment(providerUserId);
	}

	public void decreaseChanceToComment(String providerUserId) {
		memberRepository.decreaseChanceToComment(providerUserId);
	}
	
	public void increaseChanceToLike(String providerUserId) {
		memberRepository.increaseChanceToLike(providerUserId);
	}
	
	public void decreaseChanceToLike(String providerUserId) {
		memberRepository.decreaseChanceToLike(providerUserId);
	}
	
	public void increaseChanceToDislike(String providerUserId) {
		memberRepository.increaseChanceToDislike(providerUserId);
	}
	
	public void decreaseChanceToDislike(String providerUserId) {
		memberRepository.decreaseChanceToDislike(providerUserId);
	}
}
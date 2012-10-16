package com.tiny.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;

import com.tiny.model.Member;
import com.tiny.repository.MemberRepository;
import com.tiny.social.SecurityContext;

@Service
public class MemberService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

	@Autowired
	private FacebookService facebookService;

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private SecurityContext securityContext;
	
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

	public Member get() {
		Member member = memberRepository.get(securityContext.getProviderUserId());
		if (member == null) {
			save();
			member = memberRepository.get(securityContext.getProviderUserId());
		}

		return member;
	}

	public Member getByProviderUserId() {
		String providerUserId = securityContext.getProviderUserId();
		Member member = memberRepository.getByProviderUserId(providerUserId);
		if (member == null) {
			save();
			member = memberRepository.getByProviderUserId(providerUserId);
		}

		return member;
	}

	public boolean isExisted() {
		boolean isExisted = true;
		Member member = memberRepository.get(securityContext.getProviderUserId());
		if (member == null) {
			isExisted = false;
		}
		return isExisted;
	}

	public boolean isChanceToDoc() {
		return memberRepository.getChanceToDoc(securityContext.getProviderUserId()) > 0;
	}

	public boolean isChanceToComment() {
		return memberRepository.getChanceToComment(securityContext.getProviderUserId()) > 0;
	}

	public boolean isChanceToLike() {
		return memberRepository.getChanceToLike(securityContext.getProviderUserId()) > 0;
	}

	public boolean isChanceToDislike() {
		return memberRepository.getChanceToDislike(securityContext.getProviderUserId()) > 0;
	}

	public void updateName(String name) {
		memberRepository.updateName(securityContext.getProviderUserId(), name);
	}

	public void updateLastLoginTime() {
		memberRepository.updateLastLoginDate(securityContext.getProviderUserId());
	}

	public void increaseChanceToDoc() {
		memberRepository.increaseChanceToDoc(securityContext.getProviderUserId());
	}

	public void decreaseChanceToDoc() {
		memberRepository.decreaseChanceToDoc(securityContext.getProviderUserId());
	}

	public void increaseChanceToComment() {
		memberRepository.increaseChanceToComment(securityContext.getProviderUserId());
	}

	public void decreaseChanceToComment() {
		memberRepository.decreaseChanceToComment(securityContext.getProviderUserId());
	}

	public void increaseChanceToLike() {
		memberRepository.increaseChanceToLike(securityContext.getProviderUserId());
	}

	public void decreaseChanceToLike() {
		memberRepository.decreaseChanceToLike(securityContext.getProviderUserId());
	}

	public void increaseChanceToDislike() {
		memberRepository.increaseChanceToDislike(securityContext.getProviderUserId());
	}

	public void decreaseChanceToDislike() {
		memberRepository.decreaseChanceToDislike(securityContext.getProviderUserId());
	}
}
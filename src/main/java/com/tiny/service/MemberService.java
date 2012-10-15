package com.tiny.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;

import com.tiny.model.Member;
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
		Member member = memberRepository.get(userConnectionRepository.getProviderUserId());
		if (member == null) {
			save();
			member = memberRepository.get(userConnectionRepository.getProviderUserId());
		}

		return member;
	}

	public Member getByProviderUserId() {
		String providerUserId = userConnectionRepository.getProviderUserId();
		Member member = memberRepository.getByProviderUserId(providerUserId);
		if (member == null) {
			save();
			member = memberRepository.getByProviderUserId(providerUserId);
		}

		return member;
	}

	public boolean isExisted() {
		boolean isExisted = true;
		Member member = memberRepository.get(userConnectionRepository.getProviderUserId());
		if (member == null) {
			isExisted = false;
		}
		return isExisted;
	}

	public boolean isChanceToDoc() {
		return memberRepository.getChanceToDoc(userConnectionRepository.getProviderUserId()) > 0;
	}

	public boolean isChanceToComment() {
		return memberRepository.getChanceToComment(userConnectionRepository.getProviderUserId()) > 0;
	}

	public boolean isChanceToLike() {
		return memberRepository.getChanceToLike(userConnectionRepository.getProviderUserId()) > 0;
	}

	public boolean isChanceToDislike() {
		return memberRepository.getChanceToDislike(userConnectionRepository.getProviderUserId()) > 0;
	}

	public void updateName(String name) {
		memberRepository.updateName(userConnectionRepository.getProviderUserId(), name);
	}

	public void updateLastLoginTime() {
		memberRepository.updateLastLoginDate(userConnectionRepository.getProviderUserId());
	}

	public void increaseChanceToDoc() {
		memberRepository.increaseChanceToDoc(userConnectionRepository.getProviderUserId());
	}

	public void decreaseChanceToDoc() {
		memberRepository.decreaseChanceToDoc(userConnectionRepository.getProviderUserId());
	}

	public void increaseChanceToComment() {
		memberRepository.increaseChanceToComment(userConnectionRepository.getProviderUserId());
	}

	public void decreaseChanceToComment() {
		memberRepository.decreaseChanceToComment(userConnectionRepository.getProviderUserId());
	}

	public void increaseChanceToLike() {
		memberRepository.increaseChanceToLike(userConnectionRepository.getProviderUserId());
	}

	public void decreaseChanceToLike() {
		memberRepository.decreaseChanceToLike(userConnectionRepository.getProviderUserId());
	}

	public void increaseChanceToDislike() {
		memberRepository.increaseChanceToDislike(userConnectionRepository.getProviderUserId());
	}

	public void decreaseChanceToDislike() {
		memberRepository.decreaseChanceToDislike(userConnectionRepository.getProviderUserId());
	}
}
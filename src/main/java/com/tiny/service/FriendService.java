package com.tiny.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Service;

import com.tiny.model.Member;
import com.tiny.repository.MemberRepository;

@Service
public class FriendService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FriendService.class);

	private FacebookService facebookService;
	private MemberRepository memberRepository;
	
	@Autowired
	FriendService(FacebookService facebookService, MemberRepository memberRepository) {
		this.facebookService = facebookService;
		this.memberRepository = memberRepository;
	}

	public List<FacebookProfile> getTemplateFriends() {
		List<FacebookProfile> result = new ArrayList<FacebookProfile>();
		List<FacebookProfile> friends = facebookService.getFriends();
		
		// TODO:: 성능 상 튜닝 필요
		for (FacebookProfile facebookProfile : friends) {
			Member member = memberRepository.getByProviderUserId(facebookProfile.getId());
			if (member != null) {
				result.add(facebookProfile);
			}
		}
		return result;
	}
}
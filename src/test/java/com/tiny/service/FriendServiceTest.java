package com.tiny.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.FriendOperations;

import com.tiny.common.CommonMockTest;
import com.tiny.member.Member;
import com.tiny.repository.MemberRepository;

public class FriendServiceTest extends CommonMockTest {
	private FriendService friendService;

	@Mock
	private MemberRepository mockMemberRepository;

	@Mock
	private FacebookService mockFacebookService;

	@Mock
	private FriendOperations mockFriendOperations;

	@Mock
	private FacebookProfile mockFacebookProfile;

	private List<FacebookProfile> mockFacebookProfiles;

	@Mock
	private Facebook mockFacebook;

	private final String providerUserId = "providerUserId";

	@Test
	public void getTemplateFriends() {
		// Given
		mockFacebookProfiles = new ArrayList<FacebookProfile>();
		when(mockFacebookProfile.getId()).thenReturn(providerUserId);
		mockFacebookProfiles.add(mockFacebookProfile);
		when(mockFacebookService.getFriends()).thenReturn(mockFacebookProfiles);
		when(mockMemberRepository.get(anyString())).thenReturn(createMember());

		// When
		FriendService friendService = new FriendService(mockFacebookService, mockMemberRepository);
		List<FacebookProfile> friends = friendService.getTemplateFriends();

		// Then
		assertThat(friends.size(), is(1));
	}

	private Member createMember() {
		Member member = new Member();
		member.setProviderUserId(providerUserId);
		member.setRegDate(new Date());
		member.setLastLogin(new Date());
		return member;
	}
}

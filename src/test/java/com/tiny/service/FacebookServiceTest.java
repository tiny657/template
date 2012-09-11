package com.tiny.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

import com.tiny.common.CommonTest;

public class FacebookServiceTest extends CommonTest {
	private FacebookTemplate facebook;

	@Before
	public void before() {
		facebook = new FacebookTemplate(
				"AAAC1oNlnFTcBAHgMtDUZCe8XZAbS3Lnl8pbZAsi9gUZCZC8iiN70eGW1ZAcZCsaki9sJJq2ODkazf9I3ZB3Vvvqz8ZCTjwxr4XnqPCePjct6FtQZDZD");
	}

	@Test
	public void testGetMemger() {
		FacebookProfile userProfile = facebook.userOperations().getUserProfile();
		assertThat(userProfile.getName(), is("Gildong Hong"));
		assertThat(userProfile.getEmail(), is("tiny657@naver.com"));
		assertThat(userProfile.getId(), is("100004435682348"));
		assertThat(userProfile.getGender(), is("male"));
	}
}

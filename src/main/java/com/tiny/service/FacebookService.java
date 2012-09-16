package com.tiny.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.ImageType;
import org.springframework.stereotype.Service;

@Service
public class FacebookService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FacebookService.class);

	@Autowired
	private Facebook facebook;

	public FacebookProfile getProfile() {
		return facebook.userOperations().getUserProfile();
	}

	public byte[] getProfileImage() {
		return facebook.userOperations().getUserProfileImage(ImageType.LARGE);
	}

	public String getId() {
		return facebook.userOperations().getUserProfile().getId();
	}

	public String getEmail() {
		return facebook.userOperations().getUserProfile().getEmail();
	}

	public String getName() {
		return facebook.userOperations().getUserProfile().getName();
	}
}

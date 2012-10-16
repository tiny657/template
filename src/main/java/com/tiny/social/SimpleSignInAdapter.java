package com.tiny.social;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class SimpleSignInAdapter implements SignInAdapter {
	
	@Autowired
	private UserCookieGenerator userCookieGenerator;
	
	@Autowired
	private SecurityContext securityContext;
	
	public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
		securityContext.setCurrentUser(new User(userId));
		userCookieGenerator.addCookie(userId, request.getNativeResponse(HttpServletResponse.class));
		return null;
	}
}
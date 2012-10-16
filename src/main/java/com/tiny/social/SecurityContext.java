package com.tiny.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiny.repository.UserConnectionRepository;

@Component
public class SecurityContext {
	private ThreadLocal<User> CURRENTUSER = new ThreadLocal<User>();
	
	@Autowired
	private UserConnectionRepository userConnectionRepository;

	public User getCurrentUser() {
		User user = CURRENTUSER.get();
		if (user == null) {
			throw new IllegalStateException("No user is currently signed in");
		}
		return user;
	}

	public void setCurrentUser(User user) {
		user.setProviderUserId(userConnectionRepository.getProviderUserId(user.getId()));
		CURRENTUSER.set(user);
	}
	
	public String getProviderUserId() {
		return CURRENTUSER.get().getProviderUserId();
	}
	
	public boolean userSignedIn() {
		return CURRENTUSER.get() != null;
	}

	public void remove() {
		CURRENTUSER.remove();
	}
}
package com.tiny.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiny.repository.UserConnectionRepository;

@Component
public class SecurityContext {
	private ThreadLocal<User> currentUser = new ThreadLocal<User>();
	
	@Autowired
	private UserConnectionRepository userConnectionRepository;

	public User getCurrentUser() {
		User user = currentUser.get();
		if (user == null) {
			throw new IllegalStateException("No user is currently signed in");
		}
		return user;
	}

	public void setCurrentUser(User user) {
		user.setProviderUserId(userConnectionRepository.getProviderUserId(user.getId()));
		currentUser.set(user);
	}
	
	public String getProviderUserId() {
		return currentUser.get().getProviderUserId();
	}
	
	public boolean userSignedIn() {
		return currentUser.get() != null;
	}

	public void remove() {
		currentUser.remove();
	}
}
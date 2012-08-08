package com.tiny.social;

public final class SecurityContext {

	private static final ThreadLocal<User> CURRENTUSER = new ThreadLocal<User>();

	public static User getCurrentUser() {
		User user = CURRENTUSER.get();
		if (user == null) {
			throw new IllegalStateException("No user is currently signed in");
		}
		return user;
	}

	public static void setCurrentUser(User user) {
		CURRENTUSER.set(user);
	}

	public static boolean userSignedIn() {
		return CURRENTUSER.get() != null;
	}

	public static void remove() {
		CURRENTUSER.remove();
	}

}

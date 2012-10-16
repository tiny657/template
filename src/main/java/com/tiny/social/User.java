package com.tiny.social;

public class User {
	private String id;
	// added by template
	private String providerUserId;

	public User(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	// added by template
	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId; 
	}
	
	public String getProviderUserId() {
		return this.providerUserId;
	}
}

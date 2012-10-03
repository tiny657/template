package com.tiny.dao;

import com.tiny.userConnection.UserConnection;

public interface UserConnectionDao {
	public void save(UserConnection userConnection);

	public String getProviderUserId(String userId);
}
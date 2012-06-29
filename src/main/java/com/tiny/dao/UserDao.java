package com.tiny.dao;

import java.util.List;
import com.tiny.domain.User;

public interface UserDao {
	public void createUser();
	public void dropUser();
	
	public void saveUser(User user);
	public List<User> getAllUser();
	public User getUser(String name);
	public Integer countUser();
	public void updateUser(User user);
	public void deleteUser(String name);
}
package com.tiny.repository;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tiny.model.User;

@Repository
public class UserRepository extends SqlSessionDaoSupport {
	public boolean createUser() {
		int result = (int)getSqlSession().update("user.createTable", "Test");
		boolean isData = (result > 0) ? true : false;
		
		return isData;
	}
	
	public boolean insertUser(User user) {
		int insertResult = (int)getSqlSession().insert("user.insertUser", user);
		boolean isInsertedData = (insertResult > 0) ? true : false;
		
		return isInsertedData;
	}
}

package com.tiny.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.tiny.dao.UserConnectionDao;
import com.tiny.social.SecurityContext;

@Repository
public class UserConnectionRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserConnectionRepository.class);

	@Autowired
	private UserConnectionDao userConnectionDao;

	@Cacheable(value = "userConnectionRepository")
	public String getProviderUserId() {
		return userConnectionDao.getProviderUserId(SecurityContext.getCurrentUser().getId());
	}
}

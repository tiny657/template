package com.tiny.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tiny.dao.LikeDao;
import com.tiny.model.Like;

@Repository
public class LikeRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(LikeRepository.class);

	@Autowired
	private LikeDao likeDao;

	public void save(Like like) {
		likeDao.save(like);
	}
	
	public List<Like> get(String providerUserId) {
		return likeDao.getByProviderUserId(providerUserId);
	}
	
	public Like get(String providerUserId, Integer documentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("providerUserId", providerUserId);
		map.put("documentId", documentId);
		return likeDao.get(map);
	}
	
	public void delete(String providerUserId, Integer documentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("providerUserId", providerUserId);
		map.put("documentId", documentId);
		likeDao.delete(map);
	}
}
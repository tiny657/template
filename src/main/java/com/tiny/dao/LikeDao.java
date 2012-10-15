package com.tiny.dao;

import java.util.List;
import java.util.Map;

import com.tiny.model.Like;

public interface LikeDao {
	public void save(Like like);
	public Like get(Map<String, Object> map);
	public List<Like> getByProviderUserId(String providerUserId);
	public Integer count();
	public void delete(Map<String, Object> map);
}
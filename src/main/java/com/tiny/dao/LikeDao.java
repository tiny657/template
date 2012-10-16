package com.tiny.dao;

import java.util.List;
import java.util.Map;

import com.tiny.model.Like;

public interface LikeDao {
	public void save(Like like);
	public List<Like> getByProviderUserId(String providerUserId);
	public List<Like> getByDocumentId(Integer documentId);
	public Like get(Map<String, Object> map);
	public Integer count();
	public void delete(Map<String, Object> map);
}
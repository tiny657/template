package com.tiny.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiny.model.Like;
import com.tiny.repository.LikeRepository;

@Service
public class LikeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LikeService.class);

	@Autowired
	private LikeRepository likeRepository;

	public void save(String providerUserId, Integer documentId, Boolean isLike) {
		Like like = new Like();
		like.setDocumentId(documentId);
		like.setProviderUserId(providerUserId);
		like.setIsLike(isLike);
		likeRepository.save(like);
	}

	public List<Like> get(String providerUserId) {
		return likeRepository.get(providerUserId);
	}
	
	public Like get(String providerUserId, Integer documentId) {
		return likeRepository.get(providerUserId, documentId);
	}
	
	public void delete(String providerUserId, Integer documentId) {
		likeRepository.delete(providerUserId, documentId);
	}
}
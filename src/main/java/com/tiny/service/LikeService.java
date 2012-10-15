package com.tiny.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiny.model.Like;
import com.tiny.repository.LikeRepository;
import com.tiny.repository.UserConnectionRepository;

@Service
public class LikeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LikeService.class);

	@Autowired
	private LikeRepository likeRepository;
	
	@Autowired
	private UserConnectionRepository userConnectionRepository;

	public void save(Integer documentId, Boolean isLike) {
		Like like = new Like();
		like.setDocumentId(documentId);
		like.setProviderUserId(userConnectionRepository.getProviderUserId());
		like.setIsLike(isLike);
		likeRepository.save(like);
	}

	public List<Like> get(String providerUserId) {
		return likeRepository.get(providerUserId);
	}
	
	public Like getByProviderUserId(Integer documentId) {
		return likeRepository.get(userConnectionRepository.getProviderUserId(), documentId);
	}
	
	public void delete(Integer documentId) {
		likeRepository.delete(userConnectionRepository.getProviderUserId(), documentId);
	}
}
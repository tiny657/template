package com.tiny.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiny.document.Document;
import com.tiny.repository.CommentRepository;
import com.tiny.repository.DocumentRepository;
import com.tiny.repository.MemberRepository;
import com.tiny.repository.UserConnectionRepository;
import com.tiny.social.SecurityContext;

@Service
public class PointService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PointService.class);

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private UserConnectionRepository userConnectionRepository;

	public void calculatePointToSaveDocument(String providerUserId) {
		memberRepository.increasePointDocument(providerUserId);
	}

	public void calculatePointToDeleteDocument(String providerUserId, int documentId) {
		int count = commentRepository.countWithDocumentId(documentId);
		// TODO:: 성능 상 하나의 쿼리로 수정 필요
		for (int i = 0; i < count; i++) {
			memberRepository.decreasePointBeCommented(providerUserId);
		}
		memberRepository.decreasePointDocument(providerUserId);
	}

	public void calculatePointToSaveComment(String providerUserId, int documentId) {
		memberRepository.increasePointComment(providerUserId);
		Document document = documentRepository.get(documentId);
		memberRepository.increasePointBeCommented(document.getProviderUserId());
		documentRepository.increasePointComment(documentId);
	}

	public void calculatePointToDeleteComment(int documentId, int commentId) {
		memberRepository.decreasePointComment(userConnectionRepository.getProviderUserId(SecurityContext
				.getCurrentUser().getId()));
		Document document = documentRepository.get(documentId);
		memberRepository.decreasePointBeCommented(document.getProviderUserId());
		documentRepository.decreasePointComment(commentRepository.getCommentId(commentId).getDocumentId());
	}

	public void calculatePointToShare(int documentId) {
		Document document = documentRepository.get(documentId);
		documentRepository.increasePointShare(documentId);
		memberRepository.increasePointShare(document.getProviderUserId());
		memberRepository.increasePointBeShared(document.getProviderUserId());
	}
	
	public void calculatePointToClickLike(int documentId) {
		Document document = documentRepository.get(documentId);
		documentRepository.increasePointLike(documentId);
		memberRepository.increasePointLike(SecurityContext.getCurrentUser().getId());
		memberRepository.increasePointBeLiked(document.getProviderUserId());
	}
	
	public void calculatePointToClickDislike(int documentId) {
		Document document = documentRepository.get(documentId);
		documentRepository.increasePointDislike(documentId);
		memberRepository.increasePointDislike(SecurityContext.getCurrentUser().getId());
		memberRepository.increasePointBeDisliked(document.getProviderUserId());
	}
}
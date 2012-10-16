package com.tiny.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiny.model.Document;
import com.tiny.repository.CommentRepository;
import com.tiny.repository.DocumentRepository;
import com.tiny.repository.MemberRepository;
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
	private SecurityContext securityContext;
	
	public void calculatePointToSaveDocument() {
		memberRepository.increasePointDoc(securityContext.getProviderUserId());
	}

	public void calculatePointToDeleteDocument(Integer documentId) {
		Integer count = commentRepository.countByDocumentId(documentId);
		// TODO:: 성능 상 하나의 쿼리로 수정 필요
		for (Integer i = 0; i < count; i++) {
			memberRepository.decreaseCommentOnMyDoc(securityContext.getProviderUserId());
		}
		memberRepository.decreasePointDocument(securityContext.getProviderUserId());
	}

	public void calculatePointToSaveComment(Integer documentId) {
		memberRepository.increaseComment(securityContext.getProviderUserId());
		Document document = documentRepository.get(documentId);
		memberRepository.increaseCommentOnMyDoc(document.getProviderUserId());
		documentRepository.increaseComment(documentId);
	}

	public void calculatePointToDeleteComment(Integer documentId, Integer commentId) {
		memberRepository.decreaseComment(securityContext.getProviderUserId());
		Document document = documentRepository.get(documentId);
		memberRepository.decreaseCommentOnMyDoc(document.getProviderUserId());
		documentRepository.decreaseComment(commentRepository.getCommentId(commentId).getDocumentId());
	}

	public void calculatePointToShare(Integer documentId) {
		Document document = documentRepository.get(documentId);
		documentRepository.increaseSharing(documentId);
		memberRepository.increaseSharing(document.getProviderUserId());
		memberRepository.increasePointBeShared(document.getProviderUserId());
	}

	public void calculatePointToClickLike(Integer documentId) {
		Document document = documentRepository.get(documentId);
		documentRepository.increaseLike(documentId);
		memberRepository.increaseLike(securityContext.getProviderUserId());
		memberRepository.increaseLikeOnMyDoc(document.getProviderUserId());
	}

	public void calculatePointToCancelLike(Integer documentId) {
		Document document = documentRepository.get(documentId);
		documentRepository.decreaseLike(documentId);
		memberRepository.decreaseLike(securityContext.getProviderUserId());
		memberRepository.decreaseLikeOnMyDoc(document.getProviderUserId());
	}

	public void calculatePointToClickDislike(Integer documentId) {
		Document document = documentRepository.get(documentId);
		documentRepository.increaseDislike(documentId);
		memberRepository.increaseDislike(securityContext.getProviderUserId());
		memberRepository.increaseDislikeOnMyDoc(document.getProviderUserId());
	}

	public void calculatePointToCancelDislike(Integer documentId) {
		Document document = documentRepository.get(documentId);
		documentRepository.decreaseDislike(documentId);
		memberRepository.decreaseDislike(securityContext.getProviderUserId());
		memberRepository.decreaseDislikeOnMyDoc(document.getProviderUserId());
	}
}
package com.tiny.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tiny.dao.MemberDao;
import com.tiny.member.Member;

@Repository
public class MemberRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberRepository.class);

	@Autowired
	private MemberDao memberDao;

	public void save(Member member) {
		memberDao.save(member);
	}

	public List<Member> getAll() {
		return memberDao.getAll();
	}
	
	public Member get(String providerUserId) {
		return memberDao.get(providerUserId);
	}
	
	public String getName(String providerUserId) {
		return memberDao.getName(providerUserId);
	}
	
	public void updateName(String userId, String name) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("name", name);
		memberDao.updateName(map);
	}

	public void increasePointDoc(String providerUserId) {
		memberDao.increaseDoc(providerUserId);
	}

	public void decreasePointDocument(String providerUserId) {
		memberDao.decreaseDoc(providerUserId);
	}

	public void increaseComment(String providerUserId) {
		memberDao.increaseComment(providerUserId);
	}

	public void decreaseComment(String providerUserId) {
		memberDao.decreaseComment(providerUserId);
	}
	
	public void increaseCommentOnMyDoc(String providerUserId) {
		memberDao.increaseCommentOnMyDoc(providerUserId);
	}

	public void decreaseCommentOnMyDoc(String providerUserId) {
		memberDao.decreaseCommentOnMyDoc(providerUserId);
	}
	
	public void increaseLike(String userId) {
		memberDao.increaseLike(userId);
	}
	
	public void decreaseLike(String userId) {
		memberDao.decreaseLike(userId);
	}
	
	public void increaseLikeOnMyDoc(String providerUserId) {
		memberDao.increaseLikeOnMyDoc(providerUserId);
	}
	
	public void decreaseLikeOnMyDoc(String providerUserId) {
		memberDao.decreaseLikeOnMyDoc(providerUserId);
	}
	
	public void increaseDislike(String userId) {
		memberDao.increaseDislike(userId);
	}
	
	public void decreaseDislike(String userId) {
		memberDao.decreaseDislike(userId);
	}
	
	public void increaseDislikeOnMyDoc(String providerUserId) {
		memberDao.increaseDislikeOnMyDoc(providerUserId);
	}
	
	public void decreaseDislikeOnMyDoc(String providerUserId) {
		memberDao.increaseDislikeOnMyDoc(providerUserId);
	}
	
	public void increaseSharing(String userId) {
		memberDao.increaseSharing(userId);
	}
	
	public void decreaseSharing(String userId) {
		memberDao.decreaseSharing(userId);
	}
	
	public void increasePointBeShared(String providerUserId) {
		memberDao.increaseSharingOfMyDoc(providerUserId);
	}
	
	public void updateLastLoginDate(String userId) {
		memberDao.updateLastLoginDate(userId);
	}
	
	public void delete(String providerUserId) {
		memberDao.delete(providerUserId);
	}
}

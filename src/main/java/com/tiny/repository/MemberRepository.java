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
	
	public void updateName(String providerUserId, String name) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("providerUserId", providerUserId);
		map.put("name", name);
		memberDao.updateName(map);
	}

	public void increaseCountToDocument(String providerUserId) {
		memberDao.increaseCountToDocument(providerUserId);
	}

	public void decreaseCountToDocument(String providerUserId) {
		memberDao.decreaseCountToDocument(providerUserId);
	}

	public void increaseCountToShare(String userId) {
		memberDao.increaseCountToShare(userId);
	}
	
	public void increaseCountToBeShared(String providerUserId) {
		memberDao.increaseCountToBeShared(providerUserId);
	}
	
	public void increaseCountToLike(String userId) {
		memberDao.increaseCountToLike(userId);
	}
	
	public void increaseCountToBeLiked(String providerUserId) {
		memberDao.increaseCountToBeLiked(providerUserId);
	}
	
	public void increaseCountToDislike(String userId) {
		memberDao.increaseCountToDislike(userId);
	}
	
	public void increaseCountToBeDisliked(String providerUserId) {
		memberDao.increaseCountToBeDisliked(providerUserId);
	}
	
	public void increaseCountToComment(String providerUserId) {
		memberDao.increaseCountToComment(providerUserId);
	}

	public void decreaseCountToComment(String providerUserId) {
		memberDao.decreaseCountToComment(providerUserId);
	}
	
	public void increaseCountToBeCommented(String providerUserId) {
		memberDao.increaseCountToBeCommented(providerUserId);
	}

	public void decreaseCountToBeCommented(String providerUserId) {
		memberDao.decreaseCountToBeCommented(providerUserId);
	}
	
	public void updateLastLoginTime(String userId) {
		memberDao.updateLastLoginTime(userId);
	}
	
	public void delete(String providerUserId) {
		memberDao.delete(providerUserId);
	}
}

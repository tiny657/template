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

	public void increasePointDocument(String providerUserId) {
		memberDao.increasePointDocument(providerUserId);
	}

	public void decreasePointDocument(String providerUserId) {
		memberDao.decreasePointDocument(providerUserId);
	}

	public void increasePointShare(String userId) {
		memberDao.increasePointShare(userId);
	}
	
	public void decreasePointShare(String userId) {
		memberDao.decreasePointShare(userId);
	}
	
	public void increasePointBeShared(String providerUserId) {
		memberDao.increasePointBeShared(providerUserId);
	}
	
	public void increasePointLike(String userId) {
		memberDao.increasePointLike(userId);
	}
	
	public void decreasePointLike(String userId) {
		memberDao.decreasePointLike(userId);
	}
	
	public void increasePointBeLiked(String providerUserId) {
		memberDao.increasePointBeLiked(providerUserId);
	}
	
	public void decreasePointBeLiked(String providerUserId) {
		memberDao.decreasePointBeLiked(providerUserId);
	}
	
	public void increasePointDislike(String userId) {
		memberDao.increasePointDislike(userId);
	}
	
	public void decreasePointDislike(String userId) {
		memberDao.increasePointDislike(userId);
	}
	
	public void increasePointBeDisliked(String providerUserId) {
		memberDao.increasePointBeDisliked(providerUserId);
	}
	
	public void decreasePointBeDisliked(String providerUserId) {
		memberDao.increasePointBeDisliked(providerUserId);
	}
	
	public void increasePointComment(String providerUserId) {
		memberDao.increasePointComment(providerUserId);
	}

	public void decreasePointComment(String providerUserId) {
		memberDao.decreasePointComment(providerUserId);
	}
	
	public void increasePointBeCommented(String providerUserId) {
		memberDao.increasePointBeCommented(providerUserId);
	}

	public void decreasePointBeCommented(String providerUserId) {
		memberDao.decreasePointBeCommented(providerUserId);
	}
	
	public void updateLastLoginTime(String userId) {
		memberDao.updateLastLoginTime(userId);
	}
	
	public void delete(String providerUserId) {
		memberDao.delete(providerUserId);
	}
}

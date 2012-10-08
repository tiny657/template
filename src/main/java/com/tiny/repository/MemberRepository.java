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
	
	public void updateLastLoginTime(String userId) {
		memberDao.updateLastLoginTime(userId);
	}
	
	public void delete(String providerUserId) {
		memberDao.delete(providerUserId);
	}

	public void updateName(String providerUserId, String name) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("providerUserId", providerUserId);
		map.put("name", name);
		memberDao.updateName(map);
	}
}

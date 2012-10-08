package com.tiny.dao;

import java.util.List;
import java.util.Map;

import com.tiny.member.Member;

public interface MemberDao {
	public void save(Member member);

	public List<Member> getAll();

	public Member get(String providerUserId);
	
	public Integer count();

	public void update(Member member);
	
	public void updateName(Map<String, String> map);
	
	public void updateLastLoginTime(String userId);

	public void delete(String userId);
}
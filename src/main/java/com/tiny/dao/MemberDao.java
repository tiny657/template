package com.tiny.dao;

import java.util.List;

import com.tiny.member.Member;

public interface MemberDao {
	public void save(Member member);

	public List<Member> getAll();

	public Member get(String providerUserId);
	
	public Integer count();

	public void update(Member member);
	
	public void updateLastLogin(String userId);

	public void delete(String userId);
}
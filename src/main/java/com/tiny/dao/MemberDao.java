package com.tiny.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.tiny.member.Member;

public interface MemberDao {
	public void createMember();

	@CacheEvict(value = "repository", allEntries = true)
	public void dropMember();

	public void saveMember(Member member);

	public List<Member> getAllMember();

	@Cacheable(value = "repository")
	public Member getMember(String userId);

	public Integer countMember();

	public void updateMember(Member member);

	public void deleteMember(String userId);
}
package com.tiny.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.tiny.member.Member;

public interface MemberDao {
	@CacheEvict(value = "repository", allEntries = true)
	public void createMember();

	@CacheEvict(value = "repository", allEntries = true)
	public void dropMember();

	@CacheEvict(value = "repository", allEntries = true)
	public void saveMember(Member member);

	@Cacheable(value = "repository")
	public List<Member> getAllMember();

	@Cacheable(value = "repository")
	public Member getMember(String userId);

	@Cacheable(value = "repository")
	public Integer countMember();

	@CacheEvict(value = "repository", allEntries = true)
	public void updateMember(Member member);

	@CacheEvict(value = "repository", allEntries = true)
	public void deleteMember(String userId);
}
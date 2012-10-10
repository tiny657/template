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
	
	public void increaseCountToShare(String userId);
	
	public void increaseCountToBeShared(String providerUserId);
	
	public void increaseCountToLike(String userId);
	
	public void increaseCountToBeLiked(String providerUserId);
	
	public void increaseCountToDislike(String userId);
	
	public void increaseCountToBeDisliked(String providerUserId);
	
	public void increaseCountToComment(String usreId);
	
	public void increaseCountToBeCommented(String providerUserId);
	
	public void updateLastLoginTime(String userId);

	public void delete(String userId);
}
package com.tiny.dao;

import java.util.List;
import java.util.Map;

import com.tiny.member.Member;

public interface MemberDao {
	public void save(Member member);

	public List<Member> getAll();

	public int count();

	public Member get(String providerUserId);
	
	public String getName(String providerUserId);
	
	public void update(Member member);
	
	public void updateName(Map<String, String> map);
	
	public void increasePointDocument(String providerUserId);

	public void decreasePointDocument(String providerUserId);
	
	public void increasePointComment(String providerUsreId);

	public void decreasePointComment(String providerUserId);
	
	public void increasePointBeCommented(String providerUserId);

	public void decreasePointBeCommented(String providerUserId);
	
	public void increasePointLike(String userId);
	
	public void decreasePointLike(String userId);
	
	public void increasePointBeLiked(String providerUserId);
	
	public void decreasePointBeLiked(String providerUserId);
	
	public void increasePointDislike(String userId);
	
	public void decreasePointDislike(String userId);
	
	public void increasePointBeDisliked(String providerUserId);
	
	public void decreasePointBeDisliked(String providerUserId);
	
	public void increasePointShare(String userId);
	
	public void decreasePointShare(String userId);
	
	public void increasePointBeShared(String providerUserId);
	
	public void decreasePointBeShared(String providerUserId);
	
	public void updateLastLoginDate(String userId);

	public void delete(String userId);
}
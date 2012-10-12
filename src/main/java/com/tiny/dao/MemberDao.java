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
	
	public void updateName(Map<String, String> map);
	
	public void increaseDoc(String providerUserId);

	public void decreaseDoc(String providerUserId);
	
	public void increaseComment(String providerUsreId);

	public void decreaseComment(String providerUserId);
	
	public void increaseCommentOnMyDoc(String providerUserId);

	public void decreaseCommentOnMyDoc(String providerUserId);
	
	public void increaseLike(String userId);
	
	public void decreaseLike(String userId);
	
	public void increaseLikeOnMyDoc(String providerUserId);
	
	public void decreaseLikeOnMyDoc(String providerUserId);
	
	public void increaseDislike(String userId);
	
	public void decreaseDislike(String userId);
	
	public void increaseDislikeOnMyDoc(String providerUserId);
	
	public void decreaseDislikeOnMyDoc(String providerUserId);
	
	public void increaseSharing(String userId);
	
	public void decreaseSharing(String userId);
	
	public void increaseSharingOfMyDoc(String providerUserId);
	
	public void decreaseSharingOfMyDoc(String providerUserId);
	
	public void updateLastLoginDate(String userId);

	public void delete(String userId);
}
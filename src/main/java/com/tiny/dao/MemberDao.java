package com.tiny.dao;

import java.util.List;
import java.util.Map;

import com.tiny.member.Member;

public interface MemberDao {
	public void save(Member member);
	public List<Member> getAll();
	public Integer count();
	public Member get(String userId);
	public Member getByProviderUserId(String providerUserId);
	public String getName(String providerUserId);
	public Integer getChanceToDoc(String userId);
	public Integer getChanceToComment(String userId);
	public Integer getChanceToLike(String userId);
	public Integer getChanceToDislike(String userId);
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
	public void increaseChanceToDoc(String providerUserId);
	public void decreaseChanceToDoc(String providerUserId);
	public void increaseChanceToComment(String providerUserId);
	public void decreaseChanceToComment(String providerUserId);
	public void increaseChanceToLike(String providerUserId);
	public void decreaseChanceToLike(String providerUserId);
	public void increaseChanceToDislike(String providerUserId);
	public void decreaseChanceToDislike(String providerUserId);
	public void updateLastLoginDate(String userId);
	public void delete(String userId);
}
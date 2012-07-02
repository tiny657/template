package com.tiny.dao;

import java.util.List;

import com.tiny.member.Member;
import com.tiny.user.User;

public interface MemberDao {
	public void createMember();
	public void dropMember();
	
	public void saveMember(Member member);
	public List<Member> getAllMember();
	public Member getMember(String userId);
	public Integer countMember();
	public void updateMember(Member member);
	public void deleteMember(String userId);
}
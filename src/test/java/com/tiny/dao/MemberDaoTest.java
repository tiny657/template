package com.tiny.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;
import com.tiny.member.Member;

public class MemberDaoTest extends CommonTest {
	@Autowired
	private MemberDao memberDao;

	@Test
	public void testInsertMember() {
		// Given
		int count = memberDao.count();

		// When
		memberDao.save(getMember());

		// Then
		assertThat(memberDao.count(), is(count + 1));
	}

	@Test
	public void testUpdateMember() {
		// Given
		memberDao.save(getMember());
		int count = memberDao.count();

		// When
		memberDao.update(getMember());

		// Then
		assertThat(memberDao.count(), is(count));
	}

	@Test
	public void testGetMember() {
		// Given
		Member memberTmp = getMember();
		memberDao.save(memberTmp);

		// When
		Member member = memberDao.get(memberTmp.getProviderUserId());

		// Then
		assertThat(member.getProviderUserId(), is(memberTmp.getProviderUserId()));
	}

	@Test
	public void testDeleteMember() {
		// Given
		Member member = getMember();
		memberDao.save(member);
		int count = memberDao.count();

		// When
		memberDao.delete(member.getProviderUserId());

		// Then
		assertThat(memberDao.count(), is(count - 1));
	}

	private Member getMember() {
		Member member = new Member();
		member.setProviderUserId(("u" + Math.random() * 100).substring(0, 12));
		member.setRegDate(new Date());
		member.setLastLogin(new Date());
		return member;
	}
}
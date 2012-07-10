package com.tiny.dao;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;
import com.tiny.member.Member;

public class MemberDaoTest extends CommonTest {
	@Autowired
	private MemberDao memberDao;

	@Before
	public void before() {
		memberDao.createMember();
	}

	@Test
	public void testInsertMember() {
		// Given
		int count = memberDao.countMember();

		// When
		memberDao.saveMember(getMember());

		// Then
		assertThat(memberDao.countMember(), is(count + 1));
	}

	@Test
	public void testUpdateMember() {
		// Given
		memberDao.saveMember(getMember());
		int count = memberDao.countMember();

		// When
		memberDao.updateMember(getMember());

		// Then
		assertThat(memberDao.countMember(), is(count));
	}

	@Test
	public void testGetMember() {
		// Given
		Member memberTmp = getMember();
		memberDao.saveMember(memberTmp);

		// When
		Member member = memberDao.getMember(memberTmp.getUserId());

		// Then
		assertThat(member.getUserId(), is(memberTmp.getUserId()));
	}

	@Test
	public void testDeleteMember() {
		// Given
		Member member = getMember();
		memberDao.saveMember(member);
		int count = memberDao.countMember();

		// When
		memberDao.deleteMember(member.getUserId());

		// Then
		assertThat(memberDao.countMember(), is(count - 1));
	}

	public Member getMember() {
		return new Member(("userId" + Math.random()).substring(0, 10), "mail@gmail.com", "nickname", "pass",
				new Date(), "desc", 100, 1, 2, 3, 4, false, false);
	}
}
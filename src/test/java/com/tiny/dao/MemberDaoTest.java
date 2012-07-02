package com.tiny.dao;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.tiny.common.CommonTest;
import com.tiny.member.Member;

public class MemberDaoTest extends CommonTest {
	@Autowired
	MemberDao memberDao;

	@Before
	public void before() {
		memberDao.createMember();
	}

	@Test
	@Rollback(false)
	public void testInsertMember() {
		int count = memberDao.countMember();
		memberDao.saveMember(getMember());
		assertThat(memberDao.countMember(), is(count + 1));
	}

	@Test
	public void testUpdateMember() {
		memberDao.saveMember(getMember());
		int count = memberDao.countMember();

		memberDao.updateMember(getMember());
		assertThat(memberDao.countMember(), is(count));
	}

	@Test
	public void testGetMember() {
		Member memberTmp = getMember();
		memberDao.saveMember(memberTmp);
		Member member = memberDao.getMember(memberTmp.getUserId());
		assertThat(member.getUserId(), is(memberTmp.getUserId()));
	}

	@Test
	public void testDeleteMember() {
		Member member = getMember();
		memberDao.saveMember(member);
		int count = memberDao.countMember();

		memberDao.deleteMember(member.getUserId());
		assertThat(memberDao.countMember(), is(count - 1));
	}
	
	public Member getMember() {
		return new Member(("userId" + Math.random()).substring(0, 10), "mail@gmail.com", "nickname", "pass", new Date(), "desc", 100, 1, 2, 3, 4, false, false);
	}
}

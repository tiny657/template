package com.tiny.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;
import com.tiny.member.Member;
import com.tiny.userConnection.UserConnection;

public class MemberDaoTest extends CommonTest {
	@Autowired
	private MemberDao memberDao;

	@Autowired
	private UserConnectionDao userConnectionDao;

	private final String userId = "userId";
	private final String providerUserId = "providerUserId";
	private final String facebook = "facebook";
	private final String accessToken = "accessToken";

	@Before
	public void setUp() {
		UserConnection userConnection = new UserConnection();
		userConnection.setUserId(userId);
		userConnection.setProviderId(facebook);
		userConnection.setProviderUserId(providerUserId);
		userConnection.setRank(1);
		userConnection.setAccessToken(accessToken);
		userConnectionDao.save(userConnection);
	}

	@Test
	public void save() {
		// Given
		int count = memberDao.count();

		// When
		memberDao.save(createMember());

		// Then
		assertThat(memberDao.count(), is(count + 1));
	}

	@Test
	public void get() {
		// Given
		Member memberTmp = createMember();
		memberDao.save(memberTmp);

		// When
		Member member = memberDao.get(memberTmp.getProviderUserId());

		// Then
		assertThat(member.getProviderUserId(), is(memberTmp.getProviderUserId()));
	}

	@Test
	public void update() {
		// Given
		memberDao.save(createMember());
		int count = memberDao.count();

		// When
		memberDao.update(createMember());

		// Then
		assertThat(memberDao.count(), is(count));
	}

	@Test
	public void updateLastLogin() throws InterruptedException {
		// Given
		Member member = createMember();
		memberDao.save(member);

		// When
		Thread.sleep(1000);
		memberDao.updateLastLogin(userId);
		Member memberAfterUpdate = memberDao.get(member.getProviderUserId());

		// Then
		assertThat(member.getLastLogin().toString(), not(memberAfterUpdate.getLastLogin().toString()));
	}

	@Test
	public void delete() {
		// Given
		Member member = createMember();
		memberDao.save(member);
		int count = memberDao.count();

		// When
		memberDao.delete(member.getProviderUserId());

		// Then
		assertThat(memberDao.count(), is(count - 1));
	}

	private Member createMember() {
		Member member = new Member();
		member.setProviderUserId(providerUserId);
		member.setRegDate(new Date());
		member.setLastLogin(new Date());
		return member;
	}
}
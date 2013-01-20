package com.jysoft.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.jysoft.entity.User;
import com.jysoft.repository.jpa.UserDao;
import com.jysoft.service.AccountService;
import com.jysoft.service.ServiceException;
import org.springside.modules.test.security.shiro.ShiroTestUtils;

public class AccountServiceTest {

	private AccountService accountService;
	@Mock
	private UserDao mockUserDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ShiroTestUtils.mockSubject("foo");

		accountService = new AccountService();
		accountService.setUserDao(mockUserDao);
	}

	@After
	public void tearDown() {
		ShiroTestUtils.clearSubject();
	}

	@Test
	public void saveUser() {
		User admin = new User();
		admin.setId(1L);

		User user = new User();
		user.setId(2L);
		user.setPlainPassword("123");

		//正常保存用户.
		accountService.saveUser(user);

		//保存超级管理用户抛出异常.
		try {
			accountService.saveUser(admin);
			fail("expected ServicExcepton not be thrown");
		} catch (ServiceException e) {
			//expected exception
		}
	}
}

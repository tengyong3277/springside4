package com.jysoft.examples.showcase.functional.soap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springside.modules.mapper.BeanMapper;
import org.springside.modules.test.category.Smoke;

import com.jysoft.data.UserData;
import com.jysoft.entity.User;
import com.jysoft.examples.showcase.functional.BaseFunctionalTestCase;
import com.jysoft.webservice.soap.AccountWebService;
import com.jysoft.webservice.soap.response.GetUserResponse;
import com.jysoft.webservice.soap.response.SearchUserResponse;
import com.jysoft.webservice.soap.response.base.IdResponse;
import com.jysoft.webservice.soap.response.base.WSResponse;
import com.jysoft.webservice.soap.response.dto.UserDTO;

/**
 * AccountService Web服务的功能测试, 测试主要的接口调用.
 * 
 * 使用在Spring applicaitonContext.xml中用<jaxws:client/>，根据AccountWebService接口创建的Client.
 * 
 * 集中在User相关接口.
 * 
 * @author calvin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "/applicationContext-soap-client.xml" })
public class AccountWebServiceWithPredefineClientFT extends BaseFunctionalTestCase {

	@Autowired
	private AccountWebService accountWebServiceClient;

	/**
	 * 测试获取用户.
	 */
	@Test
	@Category(Smoke.class)
	public void getUser() {
		GetUserResponse response = accountWebServiceClient.getUser(1L);
		assertEquals("admin", response.getUser().getLoginName());
	}

	/**
	 * 测试搜索用户
	 */
	@Test
	public void searchUser() {

		SearchUserResponse response = accountWebServiceClient.searchUser(null, null);

		assertTrue(response.getUserList().size() >= 4);
		assertEquals("Jack", response.getUserList().get(0).getName());
	}

	/**
	 * 测试创建用户.
	 */
	@Test
	public void createUser() {
		User user = UserData.randomUser();
		UserDTO userDTO = BeanMapper.map(user, UserDTO.class);

		IdResponse response = accountWebServiceClient.createUser(userDTO);
		assertNotNull(response.getId());
		GetUserResponse response2 = accountWebServiceClient.getUser(response.getId());
		assertEquals(user.getLoginName(), response2.getUser().getLoginName());
	}

	/**
	 * 测试创建用户,使用错误的登录名.
	 */
	@Test
	public void createUserWithInvalidLoginName() {
		User user = UserData.randomUser();
		UserDTO userDTO = BeanMapper.map(user, UserDTO.class);

		//登录名为空
		userDTO.setLoginName(null);
		IdResponse response = accountWebServiceClient.createUser(userDTO);
		assertEquals(WSResponse.PARAMETER_ERROR, response.getCode());

		//登录名重复
		userDTO.setLoginName("user");
		response = accountWebServiceClient.createUser(userDTO);
		assertEquals(WSResponse.PARAMETER_ERROR, response.getCode());
	}
}

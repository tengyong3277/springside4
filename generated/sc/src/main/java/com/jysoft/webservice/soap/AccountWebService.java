package com.jysoft.webservice.soap;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.jysoft.webservice.soap.response.GetTeamDetailResponse;
import com.jysoft.webservice.soap.response.GetUserResponse;
import com.jysoft.webservice.soap.response.SearchUserResponse;
import com.jysoft.webservice.soap.response.base.IdResponse;
import com.jysoft.webservice.soap.response.dto.UserDTO;

/**
 * JAX-WS2.0的WebService接口定义类.
 * 
 * 使用JAX-WS2.0 annotation设置WSDL中的定义.
 * 使用WSResult及其子类类包裹返回结果.
 * 使用DTO传输对象隔绝系统内部领域对象的修改对外系统的影响.
 * 
 * @author calvin
 */
@WebService(name = "AccountService", targetNamespace = WsConstants.NS)
public interface AccountWebService {
	/**
	 * 获取团队的详细信息.
	 */
	GetTeamDetailResponse getTeamDetail(@WebParam(name = "id") Long id);

	/**
	 * 获取用户信息.
	 */
	GetUserResponse getUser(@WebParam(name = "id") Long id);

	/**
	 * 搜索用户信息.
	 */
	SearchUserResponse searchUser(@WebParam(name = "loginName") String loginName, @WebParam(name = "name") String name);

	/**
	 * 新建用户.
	 */
	IdResponse createUser(@WebParam(name = "user") UserDTO user);

}

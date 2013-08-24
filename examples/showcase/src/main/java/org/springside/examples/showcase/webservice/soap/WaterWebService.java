package org.springside.examples.showcase.webservice.soap;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springside.examples.showcase.webservice.soap.response.GetTeamDetailResponse;
import org.springside.examples.showcase.webservice.soap.response.GetUserResponse;
import org.springside.examples.showcase.webservice.soap.response.SearchUserResponse;
import org.springside.examples.showcase.webservice.soap.response.base.IdResponse;
import org.springside.examples.showcase.webservice.soap.response.dto.UserDTO;

/**
 * JAX-WS2.0的WebService接口定义类.
 * 
 * 使用JAX-WS2.0 annotation设置WSDL中的定义.
 * 使用WSResult及其子类类包裹返回结果.
 * 使用DTO传输对象隔绝系统内部领域对象的修改对外系统的影响.
 * 
 * @author calvin
 */
@WebService(name = "WaterService", targetNamespace = WsConstants.NS)
public interface WaterWebService {

	/**
	 * 获取用户信息.
	 */
	GetUserResponse getMessage(@WebParam(name = "id") Long id);


}

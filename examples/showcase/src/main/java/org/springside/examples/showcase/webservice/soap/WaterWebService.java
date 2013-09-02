package org.springside.examples.showcase.webservice.soap;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springside.examples.showcase.webservice.soap.response.SearchMessageResponse;

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
	
	SearchMessageResponse searchMessage(@WebParam(name = "loginName") String loginName, @WebParam(name = "name") String name);


}

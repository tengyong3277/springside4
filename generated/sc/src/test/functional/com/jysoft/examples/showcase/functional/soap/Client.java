package com.jysoft.examples.showcase.functional.soap;

import static org.junit.Assert.assertEquals;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.jysoft.examples.showcase.functional.BaseFunctionalTestCase;
import com.jysoft.webservice.soap.AccountWebService;
import com.jysoft.webservice.soap.response.GetTeamDetailResponse;

public class Client extends BaseFunctionalTestCase{


	public static AccountWebService creatClient() {
		String address = baseUrl + "/soap/accountservice";

		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setAddress(address);
		proxyFactory.setServiceClass(AccountWebService.class);
		AccountWebService accountWebServiceProxy = (AccountWebService) proxyFactory.create();

		//(可选)演示重新设定endpoint address.
		((BindingProvider) accountWebServiceProxy).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				address);

		//(可选)演示重新设定Timeout时间
//		Client client = ClientProxy.getClient(accountWebServiceProxy);
//		HTTPConduit conduit = (HTTPConduit) client.getConduit();
//		HTTPClientPolicy policy = conduit.getClient();
//		policy.setReceiveTimeout(600000);

		return accountWebServiceProxy;
	}

	/**
	 * 测试搜索用户
	 */
	
//	public void getTeamDetail() {
		 public static void main(String[] args){
		AccountWebService accountWebService = creatClient();

		GetTeamDetailResponse response = accountWebService.getTeamDetail(1L);
		assertEquals("Dolphin", response.getTeam().getName());
		assertEquals("Admin", response.getTeam().getMaster().getName());
	}



}

package org.springside.examples.showcase.functional.soap;

import static org.junit.Assert.assertEquals;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springside.examples.showcase.functional.BaseFunctionalTestCase;
import org.springside.examples.showcase.webservice.soap.AccountWebService;
import org.springside.examples.showcase.webservice.soap.AccountWebServiceImpl;
import org.springside.examples.showcase.webservice.soap.response.GetTeamDetailResponse;
import org.springside.modules.test.category.Smoke;

public class Client extends BaseFunctionalTestCase{
	
	private static Logger logger = LoggerFactory.getLogger(Client.class);

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
		logger.debug("accountWebService ====--==== "+accountWebService);
		GetTeamDetailResponse response = accountWebService.getTeamDetail(1L);
		assertEquals("Dolphin", response.getTeam().getName());
		assertEquals("Admin", response.getTeam().getMaster().getName());
	}



}

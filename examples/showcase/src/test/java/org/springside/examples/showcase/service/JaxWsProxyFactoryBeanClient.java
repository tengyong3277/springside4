package org.springside.examples.showcase.service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springside.examples.showcase.webservice.soap.AccountWebService;
import org.springside.examples.showcase.webservice.soap.WaterWebService;
import org.springside.examples.showcase.webservice.soap.response.SearchMessageResponse;
import org.springside.examples.showcase.webservice.soap.response.SearchUserResponse;

public class JaxWsProxyFactoryBeanClient {
	public static void main(String[] arg){
        JaxWsProxyFactoryBean soapFactoryBean = new JaxWsProxyFactoryBean();
        soapFactoryBean.setAddress("http://127.0.0.1:8080/showcase/soap/accountservice");    // 这个就是第一个工程完成后所测试的地址。
        soapFactoryBean.setServiceClass(AccountWebService.class);
        Object o = soapFactoryBean.create();
        AccountWebService accountWebService = (AccountWebService) o;
		SearchUserResponse searchUserResponse=accountWebService.searchUser("qk", "qk");
		System.out.println(searchUserResponse.getUserList());
		
		soapFactoryBean.setAddress("http://127.0.0.1:8080/showcase/soap/waterservice");    // 这个就是第一个工程完成后所测试的地址。
        soapFactoryBean.setServiceClass(WaterWebService.class);
        o = soapFactoryBean.create();
        WaterWebService waterWebService = (WaterWebService) o;
        SearchMessageResponse searchMessageResponse=waterWebService.searchMessage("", "");
        System.out.println("searchMessageResponse="+searchMessageResponse.getMessageList());
    }	
}

package org.springside.examples.showcase.service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springside.examples.showcase.webservice.soap.WaterWebService;
import org.springside.examples.showcase.webservice.soap.response.SearchMessageResponse;

public class JaxWsProxyFactoryBeanClient {
	public static void main(String[] arg){
        JaxWsProxyFactoryBean soapFactoryBean = new JaxWsProxyFactoryBean();
        //http://192.157.242.30:8080/showcase/soap/waterservice?wsdl
		soapFactoryBean.setAddress("http://192.157.242.30:8080/showcase/soap/waterservice");    // 这个就是第一个工程完成后所测试的地址。
        soapFactoryBean.setServiceClass(WaterWebService.class);
        Object o = soapFactoryBean.create();
        WaterWebService waterWebService = (WaterWebService) o;
        SearchMessageResponse searchMessageResponse=waterWebService.searchMessage("", "");
        System.out.println("searchMessageResponse="+searchMessageResponse.getMessageList());
    }	
}

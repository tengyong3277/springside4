package org.springside.examples.showcase.service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springside.examples.showcase.webservice.soap.response.SearchMessageResponse;

public class TestSearch {

	public static void main(String[] args) throws Exception {

		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf
				.createClient("http://127.0.0.1:8080/showcase/soap/waterservice?wsdl");

		Object[] objects = client.invoke("searchMessage", "test args", "");
		System.out.println(((SearchMessageResponse) objects[0]));
	}
}
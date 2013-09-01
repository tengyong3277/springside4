package org.springside.examples.showcase ;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import org.springside.examples.showcase.webservice.soap.WsConstants;
import org.springside.examples.showcase.webservice.soap.response.base.WSResponse;
import org.springside.examples.showcase.webservice.soap.response.dto.MessageDTO;

@XmlType(name = "SearchMessageResponse", namespace = WsConstants.NS)
public class SearchMessageResponse1 extends WSResponse {

	private List<MessageDTO> userList;

	public SearchMessageResponse1() {
	}

	public SearchMessageResponse1(List<MessageDTO> userList) {
		this.userList = userList;
	}

	@XmlElementWrapper(name = "userList")
	@XmlElement(name = "user")
	public List<MessageDTO> getMessageList() {
		return userList;
	}

	public void setMessageList(List<MessageDTO> userList) {
		this.userList = userList;
	}
}

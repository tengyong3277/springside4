package org.springside.examples.showcase.webservice.soap.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import org.springside.examples.showcase.webservice.soap.WsConstants;
import org.springside.examples.showcase.webservice.soap.response.base.WSResponse;
import org.springside.examples.showcase.webservice.soap.response.dto.MessageDTO;

@XmlType(name = "SearchMessageResponse", namespace = WsConstants.NS)
public class SearchMessageResponse extends WSResponse {

	private List<MessageDTO> messageList;

	public SearchMessageResponse() {
	}

	public SearchMessageResponse(List<MessageDTO> messageList) {
		this.messageList = messageList;
	}

	@XmlElementWrapper(name = "messageList")
	@XmlElement(name = "message")
	public List<MessageDTO> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<MessageDTO> messageList) {
		this.messageList = messageList;
	}
}

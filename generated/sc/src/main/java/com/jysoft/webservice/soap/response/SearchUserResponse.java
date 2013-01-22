package com.jysoft.webservice.soap.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.jysoft.webservice.soap.WsConstants;
import com.jysoft.webservice.soap.response.base.WSResponse;
import com.jysoft.webservice.soap.response.dto.UserDTO;

@XmlType(name = "SearchUserResponse", namespace = WsConstants.NS)
public class SearchUserResponse extends WSResponse {

	private List<UserDTO> userList;

	public SearchUserResponse() {
	}

	public SearchUserResponse(List<UserDTO> userList) {
		this.userList = userList;
	}

	@XmlElementWrapper(name = "userList")
	@XmlElement(name = "user")
	public List<UserDTO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDTO> userList) {
		this.userList = userList;
	}
}

package com.jysoft.webservice.soap.response;

import javax.xml.bind.annotation.XmlType;

import com.jysoft.webservice.soap.WsConstants;
import com.jysoft.webservice.soap.response.base.WSResponse;
import com.jysoft.webservice.soap.response.dto.UserDTO;

@XmlType(name = "GetUserResponse", namespace = WsConstants.NS)
public class GetUserResponse extends WSResponse {
	private UserDTO user;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}

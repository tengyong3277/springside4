package com.jysoft.webservice.soap.response;

import javax.xml.bind.annotation.XmlType;

import com.jysoft.webservice.soap.WsConstants;
import com.jysoft.webservice.soap.response.base.WSResponse;
import com.jysoft.webservice.soap.response.dto.TeamDTO;

@XmlType(name = "GetTeamDetailResponse", namespace = WsConstants.NS)
public class GetTeamDetailResponse extends WSResponse {

	private TeamDTO team;

	public GetTeamDetailResponse() {
	}

	public GetTeamDetailResponse(TeamDTO team) {
		this.team = team;
	}

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}
}

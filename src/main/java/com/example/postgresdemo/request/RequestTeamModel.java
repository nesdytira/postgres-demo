package com.example.postgresdemo.request;

public class RequestTeamModel {
	
	private String teamSign;
	private String teamDesc;
	
	public String getTeamSign() {
		return teamSign;
	}
	public void setTeamSign(String teamSign) {
		this.teamSign = teamSign;
	}
	public String getTeamDesc() {
		return teamDesc;
	}
	public void setTeamDesc(String teamDesc) {
		this.teamDesc = teamDesc;
	}
	
	@Override
	public String toString() {
		return "RequestTeamModel [teamSign=" + teamSign + ", teamDesc=" + teamDesc + "]";
	}
	
	
	
}

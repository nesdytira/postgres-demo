package com.example.postgresdemo.request;

import java.util.Date;

public class RequestPerformedSetlistNew {
	private Long setlistID;
	private Long teamID;
	private Date startDate;
	
	public Long getSetlistID() {
		return setlistID;
	}
	public void setSetlistID(Long setlistID) {
		this.setlistID = setlistID;
	}
	public Long getTeamID() {
		return teamID;
	}
	public void setTeamID(Long teamID) {
		this.teamID = teamID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
}

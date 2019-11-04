package com.example.postgresdemo.request;

import java.sql.Date;

public class RequestMemberModel {
	
	private String memberName;
	private String memberNick;
	private Date dateOfBirth;
	private String golDar;
	private int activeStatus;
	private int generation;
	private Long teamID;
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGolDar() {
		return golDar;
	}
	public void setGolDar(String golDar) {
		this.golDar = golDar;
	}
	public int getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public Long getTeamID() {
		return teamID;
	}
	public void setTeamID(Long teamID) {
		this.teamID = teamID;
	}
	
	@Override
	public String toString() {
		return "RequestMemberModel [memberName=" + memberName + ", memberNick=" + memberNick + ", dateOfBirth="
				+ dateOfBirth + ", golDar=" + golDar + ", activeStatus=" + activeStatus + ", generation=" + generation
				+ ", teamID=" + teamID + "]";
	}
	
	
	
}

package com.example.postgresdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_Team")
public class TeamModel {
	
	@Id
	@Column(name = "TeamID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // OTOMATIS, TANPA GENERATOR
	private Long teamID;
	
	@Column(name = "TeamSign")
	private String teamSign;
	
	@Column(name = "TeamDesc")
	private String teamDesc;
	
	//GETTERS AND SETTER
	public Long getTeamID() {
		return teamID;
	}
	public void setTeamID(Long teamID) {
		this.teamID = teamID;
	}
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
		return "TimModel [teamID=" + teamID + ", teamSign=" + teamSign + ", teamDesc=" + teamDesc + "]";
	}
	
	
}

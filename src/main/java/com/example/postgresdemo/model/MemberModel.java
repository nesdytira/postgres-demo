package com.example.postgresdemo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_Member")
public class MemberModel {
	
	@Id
	@Column(name = "MemberID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // OTOMATIS, TANPA GENERATOR
	private Long memberID;
	
	@Column(name = "MemberName")
	private String memberName;
	
	@Column(name = "MemberNick")
	private String memberNick;
	
	@Column(name = "DateOfBirth")
	private Date dateOfBirth;
	
	@Column(name = "GolDar")
	private String golDar;
	
	@Column(name = "ActiveStatus")
	private int activeStatus;
	
	@Column(name = "Generation")
	private int generation;

	@Column(name = "TeamID")
	private Long teamID;
	
	//GETTERS AND SETTERS
	public Long getMemberID() {
		return memberID;
	}
	public void setMemberID(Long memberID) {
		this.memberID = memberID;
	}
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
		return "MemberModel [memberID=" + memberID + ", memberName=" + memberName + ", memberNick=" + memberNick
				+ ", dateOfBirth=" + dateOfBirth + ", golDar=" + golDar + ", activeStatus=" + activeStatus
				+ ", generation=" + generation + ", teamID=" + teamID + "]";
	}
	
	
	
	
}

package com.example.postgresdemo.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.postgresdemo.model.MemberModel;

@Entity
@Table(name="TR_MemberTeather")
public class PerformMember {
	
	@Id
	@Column(name="PerformMemberID", nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long performMemberID;
	
	@ManyToOne
	@JoinColumn(name="ScheduleTeatherID")
	private ScheduleTeather scheduleTeather;
	
	@ManyToOne
	@JoinColumn(name="MemberID")
	private MemberModel member;

	public Long getPerformMemberID() {
		return performMemberID;
	}

	public void setPerformMemberID(Long performMemberID) {
		this.performMemberID = performMemberID;
	}

	public ScheduleTeather getScheduleTeather() {
		return scheduleTeather;
	}

	public void setScheduleTeather(ScheduleTeather scheduleTeather) {
		this.scheduleTeather = scheduleTeather;
	}

	public MemberModel getMember() {
		return member;
	}

	public void setMember(MemberModel member) {
		this.member = member;
	}
	
	
}

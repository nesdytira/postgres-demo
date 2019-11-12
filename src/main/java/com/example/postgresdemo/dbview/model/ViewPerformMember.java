package com.example.postgresdemo.dbview.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ViewPerformMember {
	@Id
	@Column(name="perform_memberid")
	private Long performMemberId;
	
	@Column(name="schedule_teatherid")
	private Long scheduleTeatherId;

	@Column(name="member_name")
	private String memberName;

	@Column(name="team_desc")
	private String teamDesc;

	@Column(name="setlist_title")
	private String setlistTitle;

	@Column(name="show_date")
	private Date showDate;

	@Column(name="show_time")
	private String showTime;

	public Long getPerformMemberId() {
		return performMemberId;
	}

	public void setPerformMemberId(Long performMemberId) {
		this.performMemberId = performMemberId;
	}

	public Long getScheduleTeatherId() {
		return scheduleTeatherId;
	}

	public void setScheduleTeatherId(Long scheduleTeatherId) {
		this.scheduleTeatherId = scheduleTeatherId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getTeamDesc() {
		return teamDesc;
	}

	public void setTeamDesc(String teamDesc) {
		this.teamDesc = teamDesc;
	}

	public String getSetlistTitle() {
		return setlistTitle;
	}

	public void setSetlistTitle(String setlistTitle) {
		this.setlistTitle = setlistTitle;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	@Override
	public String toString() {
		return "ViewPerformMember [performMemberId=" + performMemberId + ", scheduleTeatherId=" + scheduleTeatherId
				+ ", memberName=" + memberName + ", teamDesc=" + teamDesc + ", setlistTitle=" + setlistTitle
				+ ", showDate=" + showDate + ", showTime=" + showTime + "]";
	}
	
	
}

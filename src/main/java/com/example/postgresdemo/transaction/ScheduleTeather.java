package com.example.postgresdemo.transaction;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TR_ScheduleTeater")
public class ScheduleTeather {
	
	@Id
	@Column(name="ScheduleTeatherID", nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleTeatherID;
	
	@Column(name="ShowDate")
	private Date showDate;
	
	@Column(name="ShowTime")
	private String showTime;
	
	@ManyToOne
	@JoinColumn(name="PerformedSetlistID")
	private PerformedSetlist performedSetlist;
	
	public Long getScheduleTeatherID() {
		return scheduleTeatherID;
	}

	public void setScheduleTeatherID(Long scheduleTeatherID) {
		this.scheduleTeatherID = scheduleTeatherID;
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

	public PerformedSetlist getPerformedSetlist() {
		return performedSetlist;
	}

	public void setPerformedSetlist(PerformedSetlist performedSetlist) {
		this.performedSetlist = performedSetlist;
	}

	@Override
	public String toString() {
		return "ScheduleTeather [scheduleTeatherID=" + scheduleTeatherID + ", showDate=" + showDate + ", showTime="
				+ showTime + ", performedSetlist=" + performedSetlist + "]";
	}
	
	
}

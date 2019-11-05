package com.example.postgresdemo.request;

import java.util.Date;

public class RequestScheduleTeatherNew {
	private Date showDate;
	private String showTime;
	private Long performedSetlistID;
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
	public Long getPerformedSetlistID() {
		return performedSetlistID;
	}
	public void setPerformedSetlistID(Long performedSetlistID) {
		this.performedSetlistID = performedSetlistID;
	}
	
	
}

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

import com.example.postgresdemo.model.SetlistModel;
import com.example.postgresdemo.model.TeamModel;

@Entity
@Table(name="TR_PerformedSetlist")
public class PerformedSetlist {
	
	@Id
	@Column(name="PerformedSetlistID", nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long performedSetlistID;
	
	/*@Column(name="SetlistID")
	private Long setlistID;
	
	@Column(name="TeamID")
	private Long teamID;*/
	
	@Column(name="ShowCount")
	private Long showCount;
	
	@Column(name="StartDate")
	private Date startDate;
	
	@Column(name="EndDate")
	private Date endDate;
	
	@Column(name="PerformedStatus")
	private int performedStatus;
	
	@ManyToOne
	@JoinColumn(name="TeamID")
	private TeamModel team;
	
	@ManyToOne
	@JoinColumn(name="SetlistID")
	private SetlistModel setlist;
	
	public Long getPerformedSetlistID() {
		return performedSetlistID;
	}
	public void setPerformedSetlistID(Long performedSetlistID) {
		this.performedSetlistID = performedSetlistID;
	}
	public Long getShowCount() {
		return showCount;
	}
	public void setShowCount(Long showCount) {
		this.showCount = showCount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public TeamModel getTeam() {
		return team;
	}
	public void setTeam(TeamModel team) {
		this.team = team;
	}
	public SetlistModel getSetlist() {
		return setlist;
	}
	public void setSetlist(SetlistModel setlist) {
		this.setlist = setlist;
	}
	public int getPerformedStatus() {
		return performedStatus;
	}
	public void setPerformedStatus(int performedStatus) {
		this.performedStatus = performedStatus;
	}
	
	
}

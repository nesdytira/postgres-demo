package com.example.postgresdemo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_Setlist")
public class SetlistModel {
	
	@Id
	@Column(name="SetlistID", nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // OTOMATIS, TANPA GENERATOR
	private Long setlistID;
	
	@Column(name="SetlistTitle")
	private String setlistTitle;
	
	@Column(name="DateAdd")
	private Date dateAdd;
	
	public Long getSetlistID() {
		return setlistID;
	}
	public void setSetlistID(Long setlistID) {
		this.setlistID = setlistID;
	}
	public String getSetlistTitle() {
		return setlistTitle;
	}
	public void setSetlistTitle(String setlistTitle) {
		this.setlistTitle = setlistTitle;
	}
	public Date getDateAdd() {
		return dateAdd;
	}
	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}
	@Override
	public String toString() {
		return "SetlistModel [setlistID=" + setlistID + ", setlistTitle=" + setlistTitle + ", dateAdd=" + dateAdd + "]";
	}
	
	
}

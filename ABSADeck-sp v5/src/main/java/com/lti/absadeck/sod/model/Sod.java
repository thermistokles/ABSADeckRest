package com.lti.absadeck.sod.model;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SOD_APP_AVL")
public class Sod  {

	@Id
	@GeneratedValue
	private int id;
	private String appName;

	private String statusDate;
	private String status;
	private String comments;
	
	public Sod(int id, String appName, String statusDate, String status, String comments) {
		super();
		this.id = id;
		this.appName = appName;
		this.statusDate = statusDate;
		this.status = status;
		this.comments = comments;
	}

	public Sod() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}

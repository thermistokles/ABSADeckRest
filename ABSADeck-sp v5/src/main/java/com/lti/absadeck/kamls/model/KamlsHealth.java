package com.lti.absadeck.kamls.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class KamlsHealth {
	
	@Id
	@GeneratedValue
	private int kamlsApplicationId;
	private String kamlsApplication;
	private String kamlsComment;
	private String kamlsStatus;
	private Date kamlsDate;
	private String lastUpdatedDate;
	
	KamlsHealth(){
		
	}

	public KamlsHealth(int kamlsApplicationId, String kamlsApplication, String kamlsComment, String kamlsStatus,
                       Date kamlsDate, String lastUpdatedDate) {
		super();
		this.kamlsApplicationId = kamlsApplicationId;
		this.kamlsApplication = kamlsApplication;
		this.kamlsComment = kamlsComment;
		this.kamlsStatus = kamlsStatus;
		this.kamlsDate = kamlsDate;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public int getKamlsApplicationId() {
		return kamlsApplicationId;
	}

	public void setKamlsApplicationId(int kamlsApplicationId) {
		this.kamlsApplicationId = kamlsApplicationId;
	}

	public String getKamlsApplication() {
		return kamlsApplication;
	}

	public void setKamlsApplication(String kamlsApplication) {
		this.kamlsApplication = kamlsApplication;
	}

	public String getKamlsComment() {
		return kamlsComment;
	}

	public void setKamlsComment(String kamlsComment) {
		this.kamlsComment = kamlsComment;
	}

	public String getKamlsStatus() {
		return kamlsStatus;
	}

	public void setKamlsStatus(String kamlsStatus) {
		this.kamlsStatus = kamlsStatus;
	}

	public Date getKamlsDate() {
		return kamlsDate;
	}

	public void setKamlsDate(Date kamlsDate) {
		this.kamlsDate = kamlsDate;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Override
	public String toString() {
		return "KamlsHealth [kamlsApplicationId=" + kamlsApplicationId + ", kamlsApplication=" + kamlsApplication
				+ ", kamlsComment=" + kamlsComment + ", kamlsStatus=" + kamlsStatus + ", kamlsDate=" + kamlsDate
				+ ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

}

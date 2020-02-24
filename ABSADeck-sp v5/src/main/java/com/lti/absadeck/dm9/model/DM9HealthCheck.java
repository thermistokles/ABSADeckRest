package com.lti.absadeck.dm9.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class DM9HealthCheck {
	
	
	
	
	@Id
	private int dm9hcid;
	private String inboundFolders;
	private String inboundFoldersComment;
	private String loggedOut;
	private String loggedOutComment;
	private String bdlFiles;
	private String bdlFilesComment;
	private String titaniumFs;
	private String titaniumFsComment;
	private String caWade;
	private String caWadeComment;
	private String sqlAgent;
	private String sqlAgentComment;
	private String gangliaStatus;
	private String gangliaStatusComment;
	
	
	
	
	
	
	
	public DM9HealthCheck() {
				super();
				
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int year  = localDate.getYear();
				int month = localDate.getMonthValue();
				int day   = localDate.getDayOfMonth();
				
				this.dm9hcid = day*1000000+month*10000+year;
				
				
	}






	public DM9HealthCheck(int dm9hcid, String inboundFolders, String inboundFoldersComment, String loggedOut,
			String loggedOutComment, String bdlFiles, String bdlFilesComment, String titaniumFs,
			String titaniumFsComment, String caWade, String caWadeComment, String sqlAgent, String sqlAgentComment,
			String gangliaStatus, String gangliaStatusComment) {
		super();
		this.dm9hcid = dm9hcid;
		this.inboundFolders = inboundFolders;
		this.inboundFoldersComment = inboundFoldersComment;
		this.loggedOut = loggedOut;
		this.loggedOutComment = loggedOutComment;
		this.bdlFiles = bdlFiles;
		this.bdlFilesComment = bdlFilesComment;
		this.titaniumFs = titaniumFs;
		this.titaniumFsComment = titaniumFsComment;
		this.caWade = caWade;
		this.caWadeComment = caWadeComment;
		this.sqlAgent = sqlAgent;
		this.sqlAgentComment = sqlAgentComment;
		this.gangliaStatus = gangliaStatus;
		this.gangliaStatusComment = gangliaStatusComment;
	}






	public int getDm9hcid() {
		return dm9hcid;
	}






	public void setDm9hcid(int dm9hcid) {
		this.dm9hcid = dm9hcid;
	}






	public String getInboundFolders() {
		return inboundFolders;
	}






	public void setInboundFolders(String inboundFolders) {
		this.inboundFolders = inboundFolders;
	}






	public String getInboundFoldersComment() {
		return inboundFoldersComment;
	}






	public void setInboundFoldersComment(String inboundFoldersComment) {
		this.inboundFoldersComment = inboundFoldersComment;
	}






	public String getLoggedOut() {
		return loggedOut;
	}






	public void setLoggedOut(String loggedOut) {
		this.loggedOut = loggedOut;
	}






	public String getLoggedOutComment() {
		return loggedOutComment;
	}






	public void setLoggedOutComment(String loggedOutComment) {
		this.loggedOutComment = loggedOutComment;
	}






	public String getBdlFiles() {
		return bdlFiles;
	}






	public void setBdlFiles(String bdlFiles) {
		this.bdlFiles = bdlFiles;
	}






	public String getBdlFilesComment() {
		return bdlFilesComment;
	}






	public void setBdlFilesComment(String bdlFilesComment) {
		this.bdlFilesComment = bdlFilesComment;
	}






	public String getTitaniumFs() {
		return titaniumFs;
	}






	public void setTitaniumFs(String titaniumFs) {
		this.titaniumFs = titaniumFs;
	}






	public String getTitaniumFsComment() {
		return titaniumFsComment;
	}






	public void setTitaniumFsComment(String titaniumFsComment) {
		this.titaniumFsComment = titaniumFsComment;
	}






	public String getCaWade() {
		return caWade;
	}






	public void setCaWade(String caWade) {
		this.caWade = caWade;
	}






	public String getCaWadeComment() {
		return caWadeComment;
	}






	public void setCaWadeComment(String caWadeComment) {
		this.caWadeComment = caWadeComment;
	}






	public String getSqlAgent() {
		return sqlAgent;
	}






	public void setSqlAgent(String sqlAgent) {
		this.sqlAgent = sqlAgent;
	}






	public String getSqlAgentComment() {
		return sqlAgentComment;
	}






	public void setSqlAgentComment(String sqlAgentComment) {
		this.sqlAgentComment = sqlAgentComment;
	}






	public String getGangliaStatus() {
		return gangliaStatus;
	}






	public void setGangliaStatus(String gangliaStatus) {
		this.gangliaStatus = gangliaStatus;
	}






	public String getGangliaStatusComment() {
		return gangliaStatusComment;
	}






	public void setGangliaStatusComment(String gangliaStatusComment) {
		this.gangliaStatusComment = gangliaStatusComment;
	}






	@Override
	public String toString() {
		return "DM9HealthCheck [dm9hcid=" + dm9hcid + ", inboundFolders=" + inboundFolders + ", inboundFoldersComment="
				+ inboundFoldersComment + ", loggedOut=" + loggedOut + ", loggedOutComment=" + loggedOutComment
				+ ", bdlFiles=" + bdlFiles + ", bdlFilesComment=" + bdlFilesComment + ", titaniumFs=" + titaniumFs
				+ ", titaniumFsComment=" + titaniumFsComment + ", caWade=" + caWade + ", caWadeComment=" + caWadeComment
				+ ", sqlAgent=" + sqlAgent + ", sqlAgentComment=" + sqlAgentComment + ", gangliaStatus=" + gangliaStatus
				+ ", gangliaStatusComment=" + gangliaStatusComment + "]";
	}
	

	
	
	
	
	

}

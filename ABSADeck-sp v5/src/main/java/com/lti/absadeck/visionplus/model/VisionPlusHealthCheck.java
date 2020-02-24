package com.lti.absadeck.visionplus.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VisionPlusHealthCheck {
	
	@Id
	private int vpid;

	private String kenyaSod;
	private String kenyaSodComment;
	private String mozambiqueSod;
	private String mozambiqueSodComment;
	private String mauritiusSod;
	private String mauritiusSodComment;
	
	
	private String kenyaBatch;
	private String kenyaBatchComment;
	private String mozambiqueBatch;
	private String mozambiqueBatchComment;
	private String mauritiusBatch;
	private String mauritiusBatchComment;
	
	
	public VisionPlusHealthCheck() {
		super();
		
		System.out.println("default");
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		localDate = localDate.minus(Period.ofDays(1));
		
		
		
		int year  = localDate.getYear();
		int month = localDate.getMonthValue();
		int day   = localDate.getDayOfMonth();
		
		
		this.vpid= day*1000000+month*10000+year;
	}
	
	
	


	public VisionPlusHealthCheck(int vpid, String kenyaSod, String kenyaSodComment, String mozambiqueSod,
			String mozambiqueSodComment, String mauritiusSod, String mauritiusSodComment, String kenyaBatch,
			String kenyaBatchComment, String mozambiqueBatch, String mozambiqueBatchComment, String mauritiusBatch,
			String mauritiusBatchComment) {
		super();
		this.vpid = vpid;
		this.kenyaSod = kenyaSod;
		this.kenyaSodComment = kenyaSodComment;
		this.mozambiqueSod = mozambiqueSod;
		this.mozambiqueSodComment = mozambiqueSodComment;
		this.mauritiusSod = mauritiusSod;
		this.mauritiusSodComment = mauritiusSodComment;
		this.kenyaBatch = kenyaBatch;
		this.kenyaBatchComment = kenyaBatchComment;
		this.mozambiqueBatch = mozambiqueBatch;
		this.mozambiqueBatchComment = mozambiqueBatchComment;
		this.mauritiusBatch = mauritiusBatch;
		this.mauritiusBatchComment = mauritiusBatchComment;
	}





	public int getVpid() {
		return vpid;
	}


	public void setVpid(int vpid) {
		this.vpid = vpid;
	}


	public String getKenyaSod() {
		return kenyaSod;
	}


	public void setKenyaSod(String kenyaSod) {
		this.kenyaSod = kenyaSod;
	}


	public String getKenyaSodComment() {
		return kenyaSodComment;
	}


	public void setKenyaSodComment(String kenyaSodComment) {
		this.kenyaSodComment = kenyaSodComment;
	}


	public String getMozambiqueSod() {
		return mozambiqueSod;
	}


	public void setMozambiqueSod(String mozambiqueSod) {
		this.mozambiqueSod = mozambiqueSod;
	}


	public String getMozambiqueSodComment() {
		return mozambiqueSodComment;
	}


	public void setMozambiqueSodComment(String mozambiqueSodComment) {
		this.mozambiqueSodComment = mozambiqueSodComment;
	}


	public String getMauritiusSod() {
		return mauritiusSod;
	}


	public void setMauritiusSod(String mauritiusSod) {
		this.mauritiusSod = mauritiusSod;
	}


	public String getMauritiusSodComment() {
		return mauritiusSodComment;
	}


	public void setMauritiusSodComment(String mauritiusSodComment) {
		this.mauritiusSodComment = mauritiusSodComment;
	}


	public String getKenyaBatch() {
		return kenyaBatch;
	}


	public void setKenyaBatch(String kenyaBatch) {
		this.kenyaBatch = kenyaBatch;
	}


	public String getKenyaBatchComment() {
		return kenyaBatchComment;
	}


	public void setKenyaBatchComment(String kenyaBatchComment) {
		this.kenyaBatchComment = kenyaBatchComment;
	}


	public String getMozambiqueBatch() {
		return mozambiqueBatch;
	}


	public void setMozambiqueBatch(String mozambiqueBatch) {
		this.mozambiqueBatch = mozambiqueBatch;
	}


	public String getMozambiqueBatchComment() {
		return mozambiqueBatchComment;
	}


	public void setMozambiqueBatchComment(String mozambiqueBatchComment) {
		this.mozambiqueBatchComment = mozambiqueBatchComment;
	}


	public String getMauritiusBatch() {
		return mauritiusBatch;
	}


	public void setMauritiusBatch(String mauritiusBatch) {
		this.mauritiusBatch = mauritiusBatch;
	}


	public String getMauritiusBatchComment() {
		return mauritiusBatchComment;
	}


	public void setMauritiusBatchComment(String mauritiusBatchComment) {
		this.mauritiusBatchComment = mauritiusBatchComment;
	}





	@Override
	public String toString() {
		return "VisionPlusHealthCheck [vpid=" + vpid + ", kenyaSod=" + kenyaSod + ", kenyaSodComment=" + kenyaSodComment
				+ ", mozambiqueSod=" + mozambiqueSod + ", mozambiqueSodComment=" + mozambiqueSodComment
				+ ", mauritiusSod=" + mauritiusSod + ", mauritiusSodComment=" + mauritiusSodComment + ", kenyaBatch="
				+ kenyaBatch + ", kenyaBatchComment=" + kenyaBatchComment + ", mozambiqueBatch=" + mozambiqueBatch
				+ ", mozambiqueBatchComment=" + mozambiqueBatchComment + ", mauritiusBatch=" + mauritiusBatch
				+ ", mauritiusBatchComment=" + mauritiusBatchComment + "]";
	}


	
	
	
	
	
	
	

}

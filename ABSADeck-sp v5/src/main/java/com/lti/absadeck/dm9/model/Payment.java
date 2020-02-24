package com.lti.absadeck.dm9.model;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Payment {


    @Id
    @GeneratedValue
    //(strategy = GenerationType.SEQUENCE, generator = "BATCH_SEQ")
    //@SequenceGenerator(sequenceName = "batch_seq", allocationSize = 1, name = "BATCH_SEQ")
    private Long paymentId;
    private String payments;
//    private String country;
    private Integer count;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDateTime;

    private String duration;


    public Payment(Long paymentId, Integer count, LocalDateTime startDateTime, LocalDateTime endDateTime,
			String duration) {
		super();
		this.paymentId = paymentId;
		this.count = count;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.duration = duration;
	}

	public Payment() {
		super();
	}

	

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	

//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}

	public String getPayments() {
		return payments;
	}

	public void setPayments(String payments) {
		this.payments = payments;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String batchDuration) {
		this.duration = batchDuration;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", payments=" + payments + ", count=" + count + ", startDateTime="
				+ startDateTime + ", endDateTime=" + endDateTime + ", duration=" + duration + "]";
	}

	
    
    
	
}

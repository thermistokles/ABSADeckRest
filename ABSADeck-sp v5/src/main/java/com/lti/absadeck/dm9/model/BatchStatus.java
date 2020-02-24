package com.lti.absadeck.dm9.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
public class BatchStatus {

    @Id
    @GeneratedValue
    //(strategy = GenerationType.SEQUENCE, generator = "BATCH_SEQ")
    //@SequenceGenerator(sequenceName = "batch_seq", allocationSize = 1, name = "BATCH_SEQ")
    private Long batchId;
    private String country;
    private String status;
    private Integer percentCompleted;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateTime;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime stopDateTime;

    private String batchDuration;
    private String remarks;

    public Long getBatchId() {
        return batchId;
    }
    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getPercentCompleted() {
        return percentCompleted;
    }
    public void setPercentCompleted(int percentCompleted) {
        this.percentCompleted = percentCompleted;
    }
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
    public LocalDateTime getStopDateTime() {
        return stopDateTime;
    }
    public void setStopDateTime(LocalDateTime stopDateTime) {
        this.stopDateTime = stopDateTime;
    }
    public String getBatchDuration() {
        return batchDuration;
    }
    public void setBatchDuration(String batchDuration) {
        this.batchDuration = batchDuration;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



    public BatchStatus() {

    }

    public BatchStatus(Long batchId, String country, String status, int percentCompleted, LocalDateTime startDateTime,
                       LocalDateTime stopDateTime, String batchDuration, String remarks) {
        super();
        this.batchId = batchId;
        this.country = country;
        this.status = status;
        this.percentCompleted = percentCompleted;
        this.startDateTime = startDateTime;
        this.stopDateTime = stopDateTime;
        this.batchDuration = batchDuration;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "BatchStatus [batchId=" + batchId + ", country=" + country + ", status=" + status + ", percentCompleted="
                + percentCompleted + ", startDateTime=" + startDateTime + ", stopDateTime=" + stopDateTime
                + ", batchDuration=" + batchDuration + ", remarks=" + remarks + ", getBatchId()=" + getBatchId()
                + ", getCountry()=" + getCountry() + ", getStatus()=" + getStatus() + ", getPercentCompleted()="
                + getPercentCompleted() + ", getStartDateTime()=" + getStartDateTime() + ", getStopDateTime()="
                + getStopDateTime() + ", getBatchDuration()=" + getBatchDuration() + ", getRemarks()=" + getRemarks()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }

}

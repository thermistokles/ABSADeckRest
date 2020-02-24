package com.lti.absadeck.visionplus.service;

import java.util.List;

import com.lti.absadeck.visionplus.model.VisionPlusHealthCheck;

public interface IVisionPlusHCService {
	
	void addVPHCStatus(VisionPlusHealthCheck vphc);
	VisionPlusHealthCheck getVisionPlusHealthCheckById(int vpid);
	List<VisionPlusHealthCheck> getAllVPReport();
	
}

package com.lti.absadeck.dm9.service;

import java.util.List;

import com.lti.absadeck.dm9.model.DM9HealthCheck;


public interface IDM9HealthCheckService {
	
	void addDM9HCStatus(DM9HealthCheck dm9hc);
	DM9HealthCheck getDM9HealthCheckById(int id);
	List<DM9HealthCheck> getAllDM9Report();

}

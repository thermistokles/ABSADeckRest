package com.lti.absadeck.dm9.service;

import java.util.List;

import com.lti.absadeck.dm9.model.DM9HealthCheck;
import com.lti.absadeck.dm9.repository.IDM9HCDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DM9HealthCheckServiceImpl implements IDM9HealthCheckService {
	
	@Autowired
	private IDM9HCDao daoRef;

	@Override
	public void addDM9HCStatus(DM9HealthCheck dm9hc) {
		// TODO Auto-generated method stub
		daoRef.save(dm9hc);
	}

	@Override
	public DM9HealthCheck getDM9HealthCheckById(int id) {
		return daoRef.findById(id).orElse(null);
	}

	@Override
	public List<DM9HealthCheck> getAllDM9Report() {
		// TODO Auto-generated method stub
		return daoRef.findAll();
	}

}

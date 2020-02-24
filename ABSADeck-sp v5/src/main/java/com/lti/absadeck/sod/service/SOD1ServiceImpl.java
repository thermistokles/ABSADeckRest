package com.lti.absadeck.sod.service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.absadeck.sod.model.*;
import com.lti.absadeck.sod.repository.SOD1Repository;
import com.lti.absadeck.sod.repository.SODRepository;



@Service
public class SOD1ServiceImpl implements SOD1Service {

	
	
	@Autowired
	private SOD1Repository sod1Repository;

	
	

	@Override
	public List<Sod1> fetchAll() {
		List<Sod1> sod1 = sod1Repository.findAll();
		Collections.reverse(sod1);
		return sod1;
	}

	@Override
	public List<Sod1> fetchAppData(String appName) {
		 
		return sod1Repository.findByAppName(appName);
	}




}

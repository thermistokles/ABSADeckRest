package com.lti.absadeck.sod.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Service;

import com.lti.absadeck.sod.model.*;
import com.lti.absadeck.sod.repository.SOD1Repository;
import com.lti.absadeck.sod.repository.SODRepository;



@Service
public class SODServiceImpl implements SODService {

	@Autowired
	private SODRepository sodRepository;
	
	@Autowired
	private SOD1Repository sod1Repository;
	
	

	

@Transactional 
	 public void add(Sod sod) {
		 Sod1 sod1 = new Sod1();
		 sod1.setAppName(sod.getAppName());
		 sod1.setComments(sod.getComments());
		 sod1.setStatus(sod.getStatus());
		 Date date = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");  
		 String strDate = formatter.format(date);
		 sod1.setStatusDate(strDate);
		 List<Sod1> list1 = sod1Repository.findByAppName("DM");
		 for(Sod1 s:list1) {
			 if(s.getStatusDate().equals(sod1.getStatusDate()) )
				 sod1Repository.delete(s);
			 }
		
				 sod1Repository.save(sod1);
				 sodRepository.save(sod);
			
		 } 

	@Override
	public List<Sod> fetchAll() {
		return sodRepository.findAll();

	}


	@Override
	public List<Sod> fetchAppData(String appName) {
		 
		return sodRepository.findByAppName(appName);
	}




}

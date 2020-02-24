package com.lti.absadeck.visionplus.service;

import java.util.List;

import com.lti.absadeck.visionplus.model.VisionPlusHealthCheck;
import com.lti.absadeck.visionplus.repository.VisionPlusHCDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VisionPlusHCServiceImpl implements IVisionPlusHCService {



	
	@Autowired
	private VisionPlusHCDao daoRef;
	
	@Override
	public void addVPHCStatus(VisionPlusHealthCheck vphc) {
		// TODO Auto-generated method stub
		daoRef.save(vphc);
		
	}

	@Override
	public VisionPlusHealthCheck getVisionPlusHealthCheckById(int vpid) {
		// TODO Auto-generated method stub
		return daoRef.findById(vpid).orElse(null);
		
		
		
	}

	@Override
	public List<VisionPlusHealthCheck> getAllVPReport() {
		// TODO Auto-generated method stub
		return daoRef.findAll();
	}


}

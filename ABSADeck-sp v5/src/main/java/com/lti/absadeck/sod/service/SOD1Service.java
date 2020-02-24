package com.lti.absadeck.sod.service;
import java.util.List;

import com.lti.absadeck.sod.model.Sod1;



public interface SOD1Service {

	

	public List<Sod1> fetchAll();
	


	

	List<Sod1> fetchAppData(String appName);
}

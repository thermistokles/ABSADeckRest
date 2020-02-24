package com.lti.absadeck.sod.service;
import java.util.List;

import com.lti.absadeck.sod.model.Sod;



public interface SODService {

	public void add(Sod sod);

	public List<Sod> fetchAll();
	


	

	List<Sod> fetchAppData(String appName);
}

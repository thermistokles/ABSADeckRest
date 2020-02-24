package com.lti.absadeck.sod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.absadeck.sod.model.Sod1;


@Repository
public interface SOD1Repository extends JpaRepository<Sod1, String>{

	List<Sod1> findByAppName(String appName);



	/*
	 * public void addSOD(Sod sod);
	 * 
	 * public List<Sod> fetch();
	 * 
	 */

}

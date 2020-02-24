package com.lti.absadeck.sod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.absadeck.sod.model.Sod;


@Repository
public interface SODRepository extends JpaRepository<Sod, String>{

	List<Sod> findByAppName(String appName);



	/*
	 * public void addSOD(Sod sod);
	 * 
	 * public List<Sod> fetch();
	 * 
	 */

}

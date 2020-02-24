package com.lti.absadeck.dm9.repository;

import com.lti.absadeck.dm9.model.DM9HealthCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IDM9HCDao extends JpaRepository<DM9HealthCheck, Integer>{

}

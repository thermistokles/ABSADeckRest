package com.lti.absadeck.visionplus.repository;

import com.lti.absadeck.visionplus.model.VisionPlusHealthCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VisionPlusHCDao extends JpaRepository<VisionPlusHealthCheck, Integer> {

}

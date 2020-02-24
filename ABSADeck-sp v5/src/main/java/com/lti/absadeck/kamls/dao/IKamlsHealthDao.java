package com.lti.absadeck.kamls.dao;


import com.lti.absadeck.kamls.model.KamlsHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKamlsHealthDao extends JpaRepository<KamlsHealth, Integer> {
	List<KamlsHealth> findByKamlsApplication(String kamlsApplication);
	
}

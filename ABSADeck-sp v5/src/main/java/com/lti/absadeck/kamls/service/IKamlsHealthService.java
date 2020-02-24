package com.lti.absadeck.kamls.service;


import com.lti.absadeck.kamls.model.KamlsHealth;

import java.util.List;

public interface IKamlsHealthService {
	List<KamlsHealth> getAllKamlsHealths();
	KamlsHealth getKamlsApplication(int kamlsApplicationId);
	void addKamlsApplication(KamlsHealth kamlsHealth);
	void updateKamlsHealth(KamlsHealth kamlsHealth, int kamlsApplicationId);
	void deleteKamlsHealth(int kamlsApplicationId);
	public void save(KamlsHealth kamlsHealth);
	List<KamlsHealth> findByKamlsApplication(String kamlsApplication);
}

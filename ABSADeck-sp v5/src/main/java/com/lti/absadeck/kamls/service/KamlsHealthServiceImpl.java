package com.lti.absadeck.kamls.service;


import com.lti.absadeck.kamls.dao.IKamlsHealthDao;
import com.lti.absadeck.kamls.model.KamlsHealth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KamlsHealthServiceImpl implements IKamlsHealthService {

	@Autowired
	private IKamlsHealthDao daoRef;

	@Override
	public List<KamlsHealth> getAllKamlsHealths() {
		// TODO Auto-generated method stub
		return daoRef.findAll();
	}

	@Override
	public KamlsHealth getKamlsApplication(int kamlsApplicationId) {
		// TODO Auto-generated method stub
		return daoRef.getOne(kamlsApplicationId);
	}

	@Override
	public void addKamlsApplication(KamlsHealth kamlsHealth) {
		// TODO Auto-generated method stub
		daoRef.save(kamlsHealth);
	}

	@Override
	public void updateKamlsHealth(KamlsHealth kamlsHealth, int kamlsApplicationId) {
		// TODO Auto-generated method stub
		daoRef.save(kamlsHealth);
	}

	@Override
	public void deleteKamlsHealth(int kamlsApplicationId) {
		// TODO Auto-generated method stub
		daoRef.deleteById(kamlsApplicationId);
	}

	@Override
	public List<KamlsHealth> findByKamlsApplication(String kamlsApplication) {
		// TODO Auto-generated method stub
		return daoRef.findByKamlsApplication(kamlsApplication);
	}
	
	@Override
    public void save(KamlsHealth kamlsHealth) {
		daoRef.save(kamlsHealth);
    }

	

}

package com.lti.absadeck.dm9.service;

import com.lti.absadeck.dm9.model.BatchStatus;
import com.lti.absadeck.dm9.repository.BatchStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class BatchStatusService {
    @Autowired
    private BatchStatusRepository batchStatusRepository;

    public List<BatchStatus> findAll() {
        List<BatchStatus> batchStatus = new ArrayList<>();
        batchStatusRepository.findAll().forEach(batchStatus::add);
        return batchStatus;
    }

    public List<BatchStatus> findByCountry(String country) {
        List<BatchStatus> batchStatus = new ArrayList<>();
        batchStatusRepository.findByCountry(country).forEach(batchStatus::add);
        return batchStatus;
    }

    public BatchStatus findById(Long id) {
        return batchStatusRepository.findByBatchId(id);
    }

    //create/update
    public void save(BatchStatus batchStatus) {
        batchStatusRepository.save(batchStatus);
    }

    //delete
    @Transactional
    public void deleteById(Long id) {
        batchStatusRepository.deleteByBatchId(id);
    }
}

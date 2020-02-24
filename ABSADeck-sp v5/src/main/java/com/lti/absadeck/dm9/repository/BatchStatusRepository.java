package com.lti.absadeck.dm9.repository;

import com.lti.absadeck.dm9.model.BatchStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchStatusRepository extends JpaRepository<BatchStatus, Long> {
    Iterable<BatchStatus> findByCountry(String country);
    void deleteByBatchId(Long id);
    BatchStatus findByBatchId(Long id);
}

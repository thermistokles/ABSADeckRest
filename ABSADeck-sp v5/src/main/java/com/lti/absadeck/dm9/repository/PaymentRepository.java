package com.lti.absadeck.dm9.repository;

import com.lti.absadeck.dm9.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment, Long> {
    //Iterable<Payment> findByCountry(String country);
    void deleteByPaymentId(Long id);
    Payment findByPaymentId(Long id);
}

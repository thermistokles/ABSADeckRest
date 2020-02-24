package com.lti.absadeck.dm9.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.lti.absadeck.dm9.model.Payment;
import com.lti.absadeck.dm9.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PaymentService {
	 @Autowired
	    private PaymentRepository paymentRepository;

	    public List<Payment> findAll() {
	        List<Payment> payment = new ArrayList<>();
	        paymentRepository.findAll().forEach(payment::add);
	        System.out.println(payment);
	        return payment;
	    }

//	    public List<Payment> findByCountry(String country) {
//	        List<Payment> payment = new ArrayList<>();
//	        paymentRepository.findByCountry(country).forEach(payment::add);
//	        return payment;
//	    }

	    public Payment findByPaymentId(Long paymentId) {
	        return paymentRepository.findByPaymentId(paymentId);
	    }

	    //create/update
	    public void save(Payment payment) {
	        paymentRepository.save(payment);
	    }

	    //delete
	    @Transactional
	    public void deleteByPaymentId(Long paymentId) {
	        paymentRepository.deleteByPaymentId(paymentId);
	    }

}

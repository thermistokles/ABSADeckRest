package com.lti.absadeck.dm9.controller;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;


import com.lti.absadeck.dm9.model.Payment;
import com.lti.absadeck.dm9.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.ValidationException;


@RestController
@RequestMapping("/dm9/payments")
@CrossOrigin
public class PaymentController {
	

	    @Autowired
	    private PaymentService paymentService;

	    public PaymentController(PaymentService paymentService) {
	        this.paymentService = paymentService;
	    }


	    @InitBinder
	    public void initBinder(WebDataBinder webDataBinder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        dateFormat.setLenient(false);
	        webDataBinder.registerCustomEditor(LocalDateTime.class, new CustomDateEditor(dateFormat, true));
	    }

	    @GetMapping("/all")
	    public List<Payment> all() {
	        return this.paymentService.findAll();
	    }

//	    @GetMapping("/country/{country}")
//	    public List<Payment> paymentByCountry(@PathVariable String country) {
//	        return paymentService.findByCountry(country);
//	    }

	    @GetMapping("/{paymentId}")
	    public Payment byPaymentId(@PathVariable Long paymentId) {
	        return this.paymentService.findByPaymentId(paymentId);
	    }

	    @PostMapping
	    public Payment save(@RequestBody Payment payment, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            throw new ValidationException();
	        }

	        // save note instance to db
	        this.paymentService.save(payment);

	        return payment; //returning for testing purpose..
	    }

	    @DeleteMapping("/{paymentId}")
	    public void delete(@PathVariable Long paymentId) {
	        this.paymentService.deleteByPaymentId(paymentId);
	    }
	}



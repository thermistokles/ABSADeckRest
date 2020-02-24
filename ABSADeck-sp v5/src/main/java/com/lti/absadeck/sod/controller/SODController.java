package com.lti.absadeck.sod.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lti.absadeck.sod.model.Sod;
import com.lti.absadeck.sod.model.Sod1;
import com.lti.absadeck.sod.service.SODService;
import com.lti.absadeck.sod.service.SOD1Service;



@RestController
@RequestMapping("/sod")
@CrossOrigin
public class SODController {

	@Autowired
	SODService sodService;
	
	
	@Autowired
	SOD1Service sod1Service;

	/*
	 * @RequestMapping("/") public String getHomePage(Model model) {
	 * model.addAttribute("successMsg", "DAILY SOD CHECK");
	 * 
	 * return "Homepage";
	 * 
	 * }
	 */

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(LocalDateTime.class, new CustomDateEditor(dateFormat, true));
	}

	/*
	 * @PostMapping public void addSODDetails(@RequestBody Sod sod, BindingResult
	 * result) {
	 * 
	 * System.out.println("Marker1"); if (result.hasErrors()) {
	 * System.out.println("Marker2"); return "NewSod"; } else { // long
	 * millis=System.currentTimeMillis(); // java.util.Date date=new
	 * java.util.Date(millis); // System.out.println(date); Timestamp timestamp =
	 * new Timestamp(System.currentTimeMillis()); sod.setStatusDate(timestamp);
	 * System.out.println(timestamp); sodService.add(sod); List<Sod> sod1 =
	 * sodService.fetchAll(); model.addAttribute("sod", sod1); //
	 * model.addAttribute("successMsg", "Data Inserted Successfully"); return
	 * "sodview";
	 * 
	 * }
	 * 
	 * 
	 * if (result.hasErrors()) { throw new ValidationException(); }
	 * 
	 * // save note instance to db this.sodService.add(sod);
	 * 
	 * //return sod; }
	 */
	@PostMapping
	 public void addSODDetails(@RequestBody Sod sod, BindingResult result) {
		LocalDate now = LocalDate.now();
		Date date = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");  
		String strDate = formatter.format(date);
		sod.setStatusDate(strDate);
		if (result.hasErrors()) { 
			throw new ValidationException(); 
			}
		 
		  this.sodService.add(sod);

	}

	@GetMapping("/getAllSOD")
	public List<Sod> getSODList(Model model) {
		System.out.println("Marker1");
		List<Sod> sod = new ArrayList<Sod>();
		System.out.println("test" + sod);
		return sodService.fetchAll();
		/*
		 * System.out.println(sod); model.addAttribute("sod", sod); return "sodview";
		 */

	}

	@GetMapping("/sodreport")
	public List<Sod1> allSODList(Model model) {
		System.out.println("Marker2");
		List<Sod> sod = new ArrayList<Sod>();
		System.out.println("test" + sod);
		return sod1Service.fetchAll();
	}
}

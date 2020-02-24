package com.lti.absadeck.kamls.controller;


import com.lti.absadeck.kamls.model.KamlsHealth;
import com.lti.absadeck.kamls.service.IKamlsHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/kamls/health")
@CrossOrigin
public class KamlsHealthController {
	
	@Autowired
	IKamlsHealthService iKamlsHealthService;
	
	@RequestMapping("/getAllKamlsHealth")
	public List<KamlsHealth> getKamlsHealthList(Model model) {
		/*
		 * List<KamlsHealth> kamlsHealthList = new ArrayList<KamlsHealth>();
		 * kamlsHealthList = iKamlsHealthService.getAllKamlsHealths();
		 * model.addAttribute("kamlsHealthList", kamlsHealthList);
		 * 
		 * SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy"); String
		 * strDate = formatter.format(kamlsHealthList.get(0).getKamlsDate());
		 * System.out.println("Date Format with dd MMMM yyyy zzzz : "+strDate);
		 * 
		 * model.addAttribute("kamlsDate", strDate); return "kamlshealthlist";
		 */
		return this.iKamlsHealthService.getAllKamlsHealths();
		
	}
	
	@GetMapping("/{kamlsApplicationId}")
    public KamlsHealth byId(@PathVariable int kamlsApplicationId) {
        return this.iKamlsHealthService.getKamlsApplication(kamlsApplicationId);
    }
	
	/*
	 * @RequestMapping("/updateKamlsHealth") public String updateEmployee(Model
	 * model, @RequestParam("kamlsApplicationId") int kamlsApplicationId) {
	 * KamlsHealth kamlsHealth =
	 * iKamlsHealthService.getKamlsApplication(kamlsApplicationId);
	 * model.addAttribute("KamlsHealthDetails", kamlsHealth); return
	 * "updateKamlsHealth"; }
	 */
	
	/*
	 * @RequestMapping("/updateKamlsHealthDetails") public String
	 * updateEmployeeDetail(@ModelAttribute("kamlsHealth") KamlsHealth kamlsHealth,
	 * BindingResult result, Model model) {
	 * 
	 * if (result.hasErrors()) { model.addAttribute("successMsg",
	 * "KAMLS Health not found"); return "updateKamlsHealth"; } else {
	 * //System.out.println("kamlsHealth"+kamlsHealth.getKamlsApplication());
	 * kamlsHealth.setLastUpdatedDate(LocalDateTime.now().toString());
	 * iKamlsHealthService.updateKamlsHealth(kamlsHealth,
	 * kamlsHealth.getKamlsApplicationId()); model.addAttribute("successMsg",
	 * "Employee Updated Successfully"); getKamlsHealthList(model);
	 * 
	 * return "kamlshealthlist"; } }
	 */
	
	/*
	 * @PostMapping public KamlsHealth save(@RequestBody KamlsHealth batchStatus,
	 * BindingResult bindingResult) { if (bindingResult.hasErrors()) { throw new
	 * ValidationException(); }
	 * 
	 * // save note instance to db this.batchStatusService.save(batchStatus);
	 * 
	 * return batchStatus; //returning for testing purpose.. }
	 */
	
	
	
	@PostMapping
    public KamlsHealth save(@RequestBody KamlsHealth kamlsHealth, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        // save note instance to db
        kamlsHealth.setLastUpdatedDate(LocalDateTime.now().toString());
        this.iKamlsHealthService.save(kamlsHealth);

        return kamlsHealth; //returning for testing purpose..
    }
}

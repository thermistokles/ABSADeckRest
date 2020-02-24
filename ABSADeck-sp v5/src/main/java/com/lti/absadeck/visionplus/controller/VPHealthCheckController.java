package com.lti.absadeck.visionplus.controller;

import com.lti.absadeck.visionplus.model.VisionPlusHealthCheck;
import com.lti.absadeck.visionplus.service.IVisionPlusHCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/absadeck")
@CrossOrigin
public class VPHealthCheckController {

    @Autowired
    IVisionPlusHCService vpServiceRef;


    @RequestMapping(value = "/vpreport/{date}", method = RequestMethod.GET)
    public VisionPlusHealthCheck displayVPStatus(@PathVariable String date) {

        String formattedDate = date.substring(8) + date.substring(5, 7) + date.substring(0, 4);

        return vpServiceRef.getVisionPlusHealthCheckById(Integer.parseInt(formattedDate));

    }


    @RequestMapping(value = "/vpsod", method = RequestMethod.POST)
    public void addVPHCStatus(@RequestBody VisionPlusHealthCheck vphc) {

        vpServiceRef.addVPHCStatus(vphc);

        //return vpServiceRef.getAllVPReport();

    }

}


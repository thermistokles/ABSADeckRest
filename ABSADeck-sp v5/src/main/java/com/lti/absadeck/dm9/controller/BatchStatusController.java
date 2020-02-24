package com.lti.absadeck.dm9.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.lti.absadeck.dm9.model.BatchStatus;
import com.lti.absadeck.dm9.model.DM9HealthCheck;
import com.lti.absadeck.dm9.model.EmailResponse;
import com.lti.absadeck.dm9.service.BatchStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/dm9/batch")
@CrossOrigin
public class BatchStatusController {
	
	//List<BatchStatus> batchList = new ArrayList<BatchStatus>();
	
    Vector<BatchStatus> v = new Vector<BatchStatus>(); 

    
   
    
    @Autowired
    private BatchStatusService batchStatusService;

    public BatchStatusController(BatchStatusService batchStatusService) {
        this.batchStatusService = batchStatusService;
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(LocalDateTime.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/all")
    public List<BatchStatus> all() {
        return this.batchStatusService.findAll();
    }
    
	
	  @GetMapping("/clearVector") public void clearVector() { v.clear();
	 
	  }
	 

    @GetMapping("/country/{country}")
    public List<BatchStatus> batchStatusByCountry(@PathVariable String country) {
        return batchStatusService.findByCountry(country);
    }

    @GetMapping("/{id}")
    public BatchStatus byId(@PathVariable Long id) {
        return this.batchStatusService.findById(id);
    }

    @PostMapping
    public BatchStatus save(@RequestBody BatchStatus batchStatus, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        System.out.println(batchStatus);
        
        // save note instance to db
        this.batchStatusService.save(batchStatus);
        
        
        v.add(batchStatus);
       // System.out.println(v);
        
        
     

        return batchStatus; //returning for testing purpose..
    }
    
    
    @RequestMapping(value = "/sendbatchemail", method = RequestMethod.GET)
  	public EmailResponse sendEmail() {
  		//System.out.println("Inside email");
  		EmailResponse r = new EmailResponse();
  		File newFile = new File("src/main/resources/script/batchstatus.txt");
  	//	JsonParser springParser = JsonParserFactory.getJsonParser();
  		
  		System.out.println("inside batch");
  		System.out.println(v);
		System.out.println(v.size());

  		
  		 Date date = new Date();  
  	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 


  		try {

  			
			/*
			 * if(dm9hc==null) { throw new NullPointerException(); }
			 */
  			
  			/*
  			 * if(newFile.exists()) { newFile.delete(); } boolean success =
  			 * newFile.createNewFile();
  			 */
  			
  			BufferedWriter out = new BufferedWriter(new FileWriter(newFile));

  			//System.out.println(success);
  			String text = "Hello World";
  			
  			
  			
  			out.write("<!DOCTYPE html>\r\n" + 
  					"<html lang=\"en\">\r\n" + 
  					"<head>\r\n"
  					+ "<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro' rel='stylesheet' type='text/css'>\r\n" + 
  					"" + 
  					"<meta charset=\"utf-8\">\r\n" + 
  					"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
  					"<style>\r\n" + 
  					"* {\r\n" + 
  					"  box-sizing: border-box;\r\n" + 
  					"}\r\n" + 
  					"\r\n" + 
  					"body {\r\n" + 
  					"  font-family: 'Source Sans Pro', sans-serif;" + 
  					"}\r\n" + 
  					"\r\n" + 
  					"/* Style the header */\r\n" + 
  					"#header {\r\n" + 
  					"  background-color: #b91320;\r\n" + 
  					"  padding: 10%;\r\n" + 
  					"  text-align: center;\r\n" + 
  					"  font-size: 100%;\r\n" + 
  					"  color:White;\r\n" + 
  					"  height: 100%;\r\n" + 
  					"  width: 100%;\r\n" + 
  					"  \r\n" + 
  					"}\r\n" + 
  									
  					"/* Style the footer */\r\n" + 
  					"#footer {\r\n" + 
  					"  /*background-color: #777;*/\r\n" + 
  					"  padding: 10px;\r\n" + 
  					"  text-align: center;\r\n" + 
  					"  color: white;\r\n" + 
  					"}\r\n" + 
  					"\r\n" + 
  					"#healthcheck {\r\n" + 
  					"  font-family: 'Source Sans Pro', sans-serif;" + 
  					"  border-collapse: collapse;\r\n" + 
  					"  width: 40%;"+
  					 "height:100%;\r\n" + 
  					"  padding: 10px;\r\n" + 
  					"}\r\n" + 
  					"\r\n"+
  				
  					"#healthcheck td, #healthcheck th {\r\n" +
  					"  font-family: 'Source Sans Pro', sans-serif;" + 
  					"  border: 1px solid black;\r\n" + 
  					"  padding: 8px;\r\n" + 
  					"word-wrap:break-word;\r\n"+
  					"}\r\n" + 
  					"\r\n" + 
  					"#healthcheck tr:nth-child(even){background-color: #f2f2f2;}\r\n" + 
  					"\r\n" + 
  					"#healthcheck tr:hover {background-color: #ddd;}\r\n" + 
  					"\r\n" + 
  					"#healthcheck th {\r\n" + 
  					"  padding-top: 12px;\r\n" + 
  					"  padding-bottom: 12px;\r\n" + 
  					"  text-align: left;\r\n" + 
  					"  background-color: #b91320;\r\n" + 
  					"  color: white;\r\n" + 
  					"}\r\n"
  					+ ""
  			
  					+"</style>\r\n" + 
  					"</head>\r\n" + 
  					"<body bgcolor=\"#DCDCDC\">\r\n" + 
  					"  <center>\r\n" );
  			/*		"<div id=\"header\">\r\n" + 
  					"  <!--<img src=\"header.jpg\" alt=\"absalogo\" align:\"center\">-->\r\n" + 
  					"  \r\n" + 
  					"  <h4>DM9 Pre-Batch Health Check Report <img src=\"D:\\poc\\poc\\src\\main\\resources\\script\\absalogo.png\" align: \"right\"> </h4>\r\n" + 
  					"<h4>Business Date : "+date+" </h4>\n"+					"  \r\n" + 
  					"\r\n" + 
  					"</div>\r\n" + 
  					"\r\n" + 
  					"\r\n"
  					+ "<b>Executive Summary :</b><p>Blah Blah Blah</p>"
  					+ "<img src=\"D:\\poc\\poc\\src\\main\\resources\\script\\Footer.jpg\"><br><br><br>"); 
  			*/
  			out.write(     "<table id=\"healthcheck\">" +
  				       "<tr><td  style=\"border-right:1px solid #b91320;padding:0px; background-color: #b91320;\" colspan=\"6\"><div id=\"header\">\r\n" + 
  				       "  <!--<img src=\"header.jpg\" alt=\"absalogo\" align:\"center\">-->\r\n" + 
  				       "  \r\n" + 
  				       "  <h4 align=\"center\">DM9 Batch Status  </h4>" + 
  				       "  \r\n<h4 align=\"center\">Business Date : "+formatter.format(date)+" </h4><br>" + 
  				       "\r\n" + 
  				       "</div></td><td style=\"border-left:1px solid #b91320;\" bgcolor=\"#b91320\"><img height=\"auto\" width=\"auto\"  src=cid:logo></td>"
  				       + ""
  				       + ""
  				       + "<tr>" +
  				       "<th>Country</th>" +
  				       "<th>Status</th>" +
  				       "<th>Complete %</th>" +
  				       "<th>Start Time</th>" +
  				       "<th>End Time</th>" +
  				       "<th>Duration</th>" +
  				       "<th>Remark</th>" +

  				       
  				     
  				       "</tr>\n");
  			
  			for(int i=0; i<v.size(); i++) {
  			out.write("<tr>");
  			out.write("<td bgcolor=\"white\">"+v.get(i).getCountry()+" </td><td bgcolor=\""+v.get(i).getStatus()+"\"> </td><td bgcolor=\"white\"> "+v.get(i).getPercentCompleted()+"</td><td bgcolor=\"white\">"+v.get(i).getStartDateTime().toString().replace("T", " ")+"</td><td bgcolor=\"white\">"+v.get(i).getStopDateTime().toString().replace("T", " ")+"</td><td bgcolor=\"white\">"+(v.get(i).getBatchDuration()==null?"":v.get(i).getBatchDuration())+"</td><td bgcolor=\"white\">"+(v.get(i).getRemarks()==null?"":v.get(i).getRemarks())+"</td>");
  			out.write("</tr>\n");
  			
  			}
  		
  			v.clear();
  			
  			out.write("<tr><td style=\"padding:0px;\" bgcolor=\"white\" colspan=\"7\"><br><pre align=\"left\">   Regards, <br>   DM Support Team</pre>"
  					+ "<div id=\"footer\">\\r" + 
  								"<img width=\"auto\" align=baseline border=0 hspace=0 src=cid:footer>"
  					+"					\"</div>"
  					+ "</td></tr>");

  			
  			/*
  			 * out.write(
  			 * 
  			 * "<tr><td bgcolor=\"white\" colspan=\"3\"><div id=\"footer\">\r\n" +
  			 * "  <img width=\"100%\" src=\"D:\\poc\\poc\\src\\main\\resources\\script\\Footer.jpg\">\r\n"
  			 * + "</div></td></tr>\r\n" + "\r\n" + "</body>\r\n" + "</html>\r\n" + "");
  			 */
  		
  			
  			out.write("</table>\n</center>\n");

  			
  		

  			/**
  			
  			out.write("<html>" +
  				       "<body>" +
  					"<h1>DM9 Health Check Report</h1>\n"+
  					"<h3>Business Date : "+date+" </h3>\n"+
  				       "<table border ='1'>" +
  				       "<tr>" +
  				       "<th>Applications</th>" +
  				       "<th>Status</th>" +
  				       "<th>Comments</th>" +
  				     
  				       "</tr>\n");
  			out.write("<tr>");
  			out.write("<td>Inbound Folders </td><td>"+dm9hc.getInboundFolders()+"</td><td> "+dm9hc.getInboundFoldersComment()+"</td>");
  			out.write("</tr>\n");

  			out.write("<tr>");
  			out.write("<td>Logged out Disconnected Users </td><td> "+dm9hc.getLoggedOut()+"</td><td> "+dm9hc.getLoggedOutComment()+"</td>");
  			out.write("</tr>\n");
  			
  			out.write("<tr>");
  			out.write("<td>BDL Files Processed </td><td> "+dm9hc.getBdlFiles()+"</td><td>"+dm9hc.getBdlFilesComment()+"</td>");
  			out.write("</tr>\n");
  			
  			out.write("<tr>");
  			out.write("<td>TitaniumFS Folder</td><td> "+dm9hc.getTitaniumFs()+"</td><td>"+dm9hc.getTitaniumFsComment()+"</td>");
  			out.write("</tr>\n");
  			
  			out.write("<tr>");
  			out.write("<td>CA WA Agent Status </td><td> "+dm9hc.getCaWade()+"</td><td> "+dm9hc.getCaWadeComment()+"</td>");
  			out.write("</tr>\n");
  			
  			out.write("<tr>");
  			out.write("<td>SQL Agent Status</td><td>"+dm9hc.getSqlAgent()+" </td><td>"+dm9hc.getSqlAgentComment()+"</td>");
  			out.write("</tr>\n");
  			
  			out.write("<tr>");
  			out.write("<td>Ganglia Status </td><td> "+dm9hc.getGangliaStatus()+" </td><td> "+dm9hc.getGangliaStatusComment()+"</td>");
  			out.write("</tr>\n");
  			
  			out.write("</table>\n");
  			out.write("<p>Regards</p><p>DM Support Team</p>");
  			out.write(
  				       "</body>\n" +
  				       "</html>"); 
  			
  		**/
  			
  			out.close(); 
  			
  			

  			
  		    Runtime.getRuntime().exec( "wscript src/main/resources/script/sendbatchmail.vbs" );
  		    System.out.println("email should be sent");
  		    
  		  //  springParser.parseMap("Email sent successfully");
  		    
  		    r.setResp("Email sent successfully");

  			
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			r.setResp("Email could not be sent");
  			e.printStackTrace();
  		}
  		
  		catch(NullPointerException e) {
  			r.setResp("Please submit the form before sending an email");
  			e.printStackTrace();
  		}
  		
  		finally {
  		
  		}
  		
  		return r;

  	}

    
    
    
      

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.batchStatusService.deleteById(id);
    }
}

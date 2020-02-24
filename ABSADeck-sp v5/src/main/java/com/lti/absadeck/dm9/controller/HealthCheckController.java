package com.lti.absadeck.dm9.controller;

import com.lti.absadeck.dm9.model.DM9HealthCheck;
import com.lti.absadeck.dm9.model.EmailResponse;
import com.lti.absadeck.dm9.service.IDM9HealthCheckService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/absadeck")
@CrossOrigin
public class HealthCheckController {

    @Autowired
    IDM9HealthCheckService serviceRef;

    @RequestMapping(value = "/dm9report/{date}", method = RequestMethod.GET)
    public DM9HealthCheck displayStatus(@PathVariable String date) {

        String formattedDate = date.substring(8) + date.substring(5, 7) + date.substring(0, 4);
        return serviceRef.getDM9HealthCheckById(Integer.parseInt(formattedDate));
    }

    @RequestMapping(value = "/dm9pre", method = RequestMethod.POST)
    public void  addDM9HCStatus(@RequestBody DM9HealthCheck dm9hc) {

        serviceRef.addDM9HCStatus(dm9hc);

        //return serviceRef.getAllDM9Report();

    }
    
   // @RequestMapping(value = "/sendemail", method = RequestMethod.POST)
    @RequestMapping(value = "/sendemail/{date}", method = RequestMethod.GET)
	public EmailResponse sendEmail(@PathVariable String date) {
		System.out.println("Inside email");
		EmailResponse r = new EmailResponse();
		File newFile = new File("src/main/resources/script/dm9.txt");
	//	JsonParser springParser = JsonParserFactory.getJsonParser();
		String formattedDate = date.substring(8) + date.substring(5, 7) + date.substring(0, 4);
		
		System.out.println(formattedDate);

		DM9HealthCheck dm9hc = serviceRef.getDM9HealthCheckById(Integer.parseInt(formattedDate));
		//System.out.println("hey : "+dm9hc);

		try {

			
			if(dm9hc==null) {
				throw new NullPointerException();
			}
			
			/*
			 * if(newFile.exists()) { newFile.delete(); } boolean success =
			 * newFile.createNewFile();
			 */
			
			BufferedWriter out = new BufferedWriter(new FileWriter(newFile));

			//System.out.println(success);
			
			
			
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
				       "<tr><td  style=\"border-right:1px solid #b91320;padding:0px; background-color: #b91320;\" colspan=\"2\"><div id=\"header\">\r\n" + 
				       "  <!--<img src=\"header.jpg\" alt=\"absalogo\" align:\"center\">-->\r\n" + 
				       "  \r\n" + 
				       "  <h4 align=\"center\">DM9 Pre-Batch Health Check Report  </h4>" + 
				       "  \r\n<h4 align=\"center\">Business Date : "+date+" </h4><br>" + 
				       "\r\n" + 
				       "</div></td><td style=\"border-left:1px solid #b91320;\" bgcolor=\"#b91320\"><img height=\"auto\" width=\"auto\"  src=cid:logo></td>"
				       + ""
				       + ""
				       + "<tr>" +
				       "<th>Applications</th>" +
				       "<th>Status</th>" +
				       "<th>Comments</th>" +
				     
				       "</tr>\n");
			out.write("<tr>");
			out.write("<td bgcolor=\"white\">Inbound Folders </td><td bgcolor=\""+dm9hc.getInboundFolders()+"\"></td><td bgcolor=\"white\"> "+(dm9hc.getInboundFoldersComment()==null?"":dm9hc.getInboundFoldersComment())+"</td>");
			out.write("</tr>\n");

			out.write("<tr>");
			out.write("<td bgcolor=\"white\">Logged out Disconnected Users </td><td bgcolor=\""+dm9hc.getLoggedOut()+"\"> </td><td bgcolor=\"white\"> "+(dm9hc.getLoggedOutComment()==null?"":dm9hc.getLoggedOutComment())+"</td>");
			out.write("</tr>\n");
			
			out.write("<tr>");
			out.write("<td bgcolor=\"white\">BDL Files Processed </td><td bgcolor=\""+dm9hc.getBdlFiles()+"\"> </td><td bgcolor=\"white\">"+(dm9hc.getBdlFilesComment()==null?"":dm9hc.getBdlFilesComment())+"</td>");
			out.write("</tr>\n");
			
			out.write("<tr>");
			out.write("<td bgcolor=\"white\">TitaniumFS Folder</td><td bgcolor=\""+dm9hc.getTitaniumFs()+"\"> </td><td bgcolor=\"white\">"+(dm9hc.getTitaniumFsComment()==null?"":dm9hc.getTitaniumFsComment())+"</td>");
			out.write("</tr>\n");
			
			out.write("<tr>");
			out.write("<td bgcolor=\"white\">CA WA Agent Status </td><td bgcolor=\""+dm9hc.getCaWade()+"\"></td><td bgcolor=\"white\"> "+(dm9hc.getCaWadeComment()==null?"":dm9hc.getCaWadeComment())+"</td>");
			out.write("</tr>\n");
			
			out.write("<tr>");
			out.write("<td bgcolor=\"white\">SQL Agent Status</td><td bgcolor=\""+dm9hc.getSqlAgent()+"\"> </td><td bgcolor=\"white\">"+(dm9hc.getSqlAgentComment()==null?"":dm9hc.getSqlAgentComment())+"</td>");
			out.write("</tr>\n");
			
			out.write("<tr>");
			out.write("<td bgcolor=\"white\">Ganglia Status </td><td bgcolor=\""+dm9hc.getGangliaStatus()+"\"> </td><td bgcolor=\"white\"> "+(dm9hc.getGangliaStatusComment()==null?"":dm9hc.getGangliaStatusComment())+"</td>");
			out.write("</tr>\n");
			
			out.write("<tr><td style=\"padding:0px;\" bgcolor=\"white\" colspan=\"3\"><br><p align=\"left\">Regards, <br>DM Support Team</p>"
					+ "<div id=\"footer\">\\r" + 
								"<img width=\"100%\" align=baseline border=0 hspace=0 src=cid:footer>"
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
			
			

			
		    Runtime.getRuntime().exec( "wscript src/main/resources/script/sendmail.vbs" );
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

		}
		
		finally {
		
		}
		
		return r;

	}

}



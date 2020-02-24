import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-body',
  templateUrl: './dm9hc.component.html',
  styleUrls: ['./dm9hc.component.css']
})
export class Dm9hcComponent implements OnInit {

  dm9Prop:DM9PreHealthCheck = {
    inboundFolders:'',
    inboundFoldersComment:'',
    loggedOut:'',
    loggedOutComment:'',
    bdlFiles:'',
    bdlFilesComment:'',
    titaniumFs:'',
    titaniumFsComment:'',
    caWade:'',
    caWadeComment:'',
    sqlAgent:'',
    sqlAgentComment:'',
    gangliaStatus:'',
    gangliaStatusComment:''
  };
  businessdate:any;
  emailResponse:any;

  constructor(private http:HttpClient) {

    this.businessdate = formatDate(this.currDate, 'yyyy-MM-dd', 'en');

   }

  currDate = new Date();
  
  ngOnInit() {
  //  this.businessdate = formatDate(this.currDate, 'yyyy-MM-dd', 'en');

    this.getDetails();

  }

  getDetails() : void{
     let url = "http://localhost:3000/absadeck/dm9report/"+ this.businessdate;
    this.http.get<DM9PreHealthCheck>(url).subscribe(
      res=>{
          //location.reload();
        // alert(''+res.resp);
       //  console.log(res.resp);
        
          if(res !=null)
          this.dm9Prop = res;

          console.log('hello '+ this.dm9Prop);
      },
      error=>{
        console.log(error);
       // alert('Email could not be sent');
      }
    );
  }

  sendEmail() : void {

      if(window.confirm("Are you sure you want to send email?")) {

    let url = "http://localhost:3000/absadeck/sendemail/"+ this.businessdate;
    this.http.get(url).subscribe(
      res=>{
          //location.reload();
        // alert(''+res.resp);
       //  console.log(res.resp);
        
          this.emailResponse = res;
          console.log(this.emailResponse.resp);
            alert(''+this.emailResponse.resp);
      },
      error=>{
        //console.log(error);
        alert('Email could not be sent');
      }
    );
      }
  }


  sendStatus() : void {
    let url = "http://localhost:3000/absadeck/dm9pre";
    this.http.post(url, this.dm9Prop).subscribe(
      res=>{
        //  location.reload();
          alert('Form submitted successfully');
      },
      error=>{
        alert(error);
      }
    );
  }

}

export interface DM9PreHealthCheck{
  inboundFolders:string;
  inboundFoldersComment:string;
  loggedOut:string;
  loggedOutComment:string;
  bdlFiles:string;
  bdlFilesComment:string;
  titaniumFs:string;
  titaniumFsComment:string;
  caWade:string;
  caWadeComment:string;
  sqlAgent:string;
  sqlAgentComment:string;
  gangliaStatus:string;
  gangliaStatusComment:string;


}

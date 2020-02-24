import { Component, OnInit } from '@angular/core';
import {formatDate} from '@angular/common';
import { HttpClient } from '@angular/common/http';

declare var tail: any;

@Component({
  selector: 'app-dm9report',
  templateUrl: './dm9hc-view.component.html',
  styleUrls: ['./dm9hc-view.component.css']
})
export class Dm9hcViewComponent implements OnInit {

  dm9report :  DM9PreHealthCheck;
  businessdate:any;
      currDate = new Date();


  constructor(private http:HttpClient) { 

    this.businessdate = formatDate(new Date(), 'yyyy-MM-dd', 'en');


    this.getDM9Report();
  }

  ngOnInit() {

    tail.DateTime(".tail-datetime-field", 
    { 
      dateFormat: "YYYY-mm-dd", 
      timeFormat: false
    });
  }

  getDM9Report(){
    let url = "http://localhost:3000/absadeck/dm9report/"+this.businessdate;

    this.http.get<DM9PreHealthCheck>(url).subscribe(
        res => {
           // alert('fetched successfully');
           this.dm9report = res;
            
           
        },
        err =>{

        }

    );

    console.log(url);
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

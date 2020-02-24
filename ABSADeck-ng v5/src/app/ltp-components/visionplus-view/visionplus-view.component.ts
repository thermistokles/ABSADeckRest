import { Component, OnInit } from '@angular/core';
import {formatDate} from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-visionplus-view',
  templateUrl: './visionplus-view.component.html',
  styleUrls: ['./visionplus-view.component.css']
})
export class VisionplusViewComponent implements OnInit {

   businessdate:any;
     vpreport : VisionPlusHealthCheck;

      currDate = new Date();


 constructor(private http:HttpClient) { 



     this.currDate.setDate(this.currDate.getDate()-1);
      this.businessdate = formatDate(this.currDate, 'yyyy-MM-dd', 'en');


    this.getVPReport();

  }


  getVPReport(){
let url = "http://localhost:3000/absadeck/vpreport/"+this.businessdate;

    this.http.get<VisionPlusHealthCheck>(url).subscribe(
        res => {
           // alert('fetched successfully');
           this.vpreport = res;
            
           
        },
        err =>{

        }

    );

    console.log(url);
  }

  ngOnInit() {
  }

}


export interface VisionPlusHealthCheck{
  kenyaSod:string;
  kenyaSodComment:string;
  mozambiqueSod:string;
  mozambiqueSodComment:string;
  mauritiusSod:string;
  mauritiusSodComment:string;


  kenyaBatch:string;
  kenyaBatchComment:string;
  mozambiqueBatch:string;
  mozambiqueBatchComment:string;
  mauritiusBatch:string;
  mauritiusBatchComment:string;



}


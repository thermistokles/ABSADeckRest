import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-visionplushc',
  templateUrl: './visionplushc.component.html',
  styleUrls: ['./visionplushc.component.css']
})
export class VisionplushcComponent implements OnInit {

  currDate=new Date;
  businessdate:any;

  vpProp:VisionPlusHealthCheck = {
  kenyaSod:'green',
  kenyaSodComment:'',
  mozambiqueSod:'green',
  mozambiqueSodComment:'',
  mauritiusSod:'green',
  mauritiusSodComment:'',


  kenyaBatch:'green',
  kenyaBatchComment:'',
  mozambiqueBatch:'green',
  mozambiqueBatchComment:'',
  mauritiusBatch:'green',
  mauritiusBatchComment:''
  };

  constructor(private http:HttpClient) {

     this.currDate.setDate(this.currDate.getDate()-1);
      this.businessdate = formatDate(this.currDate, 'yyyy-MM-dd', 'en');

   }

  ngOnInit() {
  }


    sendVPStatus() : void {
    let url = "http://localhost:3000/absadeck/vpsod";
    this.http.post(url, this.vpProp).subscribe(
      res=>{
          location.reload();
          alert('inserted successfully');
      },
      error=>{
        alert(error);
      }
    );
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

import { Component, OnInit } from '@angular/core';
import {Sod} from "./model/sod";
import {ApiService} from "../shared/api.service";
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-addsod',
  templateUrl: './sod.component.html',
  styleUrls: ['./sod.component.css']
})
export class SodComponent implements OnInit {


  dm: Sod;
  sods: Sod[];
  // kamls: Sod;
  //vplus: Sod;
  //today: number = Date.now();
  today: any = new Date();



  constructor(private apiService: ApiService, public datepipe: DatePipe) {
  }

  ngOnInit() {
   this.getAllSod();
  }


  addData() {
    
    
    //this.dm.statusDate = this.datepipe.transform(this.today, 'yyyy-MM-dd HH:mm:ss');
   // this.kamls.statusDate = this.datepipe.transform(this.today, 'yyyy-MM-dd HH:mm:ss');
    //this.vplus.statusDate = this.datepipe.transform(this.today, 'yyyy-MM-dd HH:mm:ss');

    //this.updateApp(this.dm);
   // this.updateApp(this.kamls);
   // this.updateApp(this.vplus);
  }

  updateApp(app: Sod) {
    console.log("Hello");
    console.log(this.dm);
    this.apiService.postSod(app).subscribe(
      res => {

      },
      err => {alert("An error has occurred while saving the batch");}
    );
  }

  public getAllSod() {
    this.apiService.getAllSod().subscribe(
       res => {
         this.sods = res;
       },
       err => {
         alert("An error has occurred;")
       }
     );
   }

  /*createSod() {
    let newSod:Sod = {
      Id:null,
      appName: "",
      statusDate:null,
      status:"",
      comments:""
    };

    this.apiService.postSod(newSod).subscribe(
      res => {
        newSod.Id = res.Id;
        this.sods.push(newSod);
      },
      err => {alert("##############");}
    );

  }*/

  updateSod(updatedSod: Sod) {
    console.log("Hello");
    this.apiService.postSod(updatedSod).subscribe(
      res => {
          location.reload();
          alert('Data Inserted Successfully');

      },
      err => {alert("An error has occurred while saving the sod");}
    );
  }
  
selectSod(){
 
}
}

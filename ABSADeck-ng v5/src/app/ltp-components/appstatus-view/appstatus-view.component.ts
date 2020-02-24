import { Component, OnInit } from '@angular/core';
import {Sod} from "../../sod/model/sod";
import {ApiService} from "../../shared/api.service";


@Component({
  selector: 'app-sod-view',
  templateUrl: './appstatus-view.component.html',
  styleUrls: ['./appstatus-view.component.css']
})
export class AppstatusViewComponent implements OnInit {

  sods: Sod[] = [];
  selectedSod: Sod;
  searchText: string;

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
    console.log("Hello");
    this.getEverySod();
  }

  public getEverySod() {
    this.apiService.getSodReport().subscribe(
      res => {
        console.log("Hello");
        this.sods = res;
      },
      err => {
        alert("An error has occurred;")
      }
    );
  }
/*
  createSod() {
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
      err => {alert("An error has occurred while saving the batch");}
    );

  }

  updatePayment(updatedSod: Sod) {
    this.apiService.postSod(updatedSod).subscribe(
      res => {

      },
      err => {alert("An error has occurred while saving the payment");}
    );
  }
*/
  

  selectSod(sod: Sod) {
    
  }
}
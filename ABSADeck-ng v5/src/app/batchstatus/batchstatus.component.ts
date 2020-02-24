

import { Component, OnInit } from '@angular/core';
import {Batch} from "./model/batch";
import {ApiService} from "../shared/api.service";
import { DatePipe } from '@angular/common';

declare var tail: any;

@Component({
  selector: 'app-batchstatus',
  templateUrl: './batchstatus.component.html',
  styleUrls: ['./batchstatus.component.css']
})
export class BatchstatusComponent implements OnInit {
 emailResponse:any;
  batches: Batch[] = [];
  //newBatches: Batch[] = [];
  currentBatches: Batch[] = [];
  today: any = new Date();//this.datepipe.transform(new Date().toDateString(), 'yyyy-MM-dd HH:mm:ss');
  startdt: string[] = [];
  stopdt: string[] = [];
  isChangedSt: boolean[] = [false, false, false, false, false, false, false, false, false, false];
  isChangedSp: boolean[] = [false, false, false, false, false, false, false, false, false, false];
  countries = ['Kenya', 'NBC', 'Uganda', 'Mozambique', 'Botswana', 'BBT', 'Ghana', 'Seychelles', 'Zambia', 'Mauritius'];
  latestBatches: Batch[] = [];
  latestBatchDate: string;
  calculatedDuration: any[] = [];

  constructor(private apiService: ApiService, public datepipe: DatePipe) {
    //for (var b in this.isChanged) b = false;
  
  }

  ngOnInit() {
   // this.today.setDate(this.today.getDate()+1); //--------------------For demo purpose to change "today"
      /*for(var i = 0; i < 10; i++) {
            this.isChanged[i].push(false);
         }*/       
    /*tail.DateTime(".tail-datetime-field", 
    { 
      dateFormat: "yyyy-MM-dd", 
      timeFormat: "HH:mm:ss"
    });*/

    this.getAllBatches();
  }


  cutTimeFromInput(date: string) : string{
    return this.datepipe.transform(date, 'yyyy-MM-dd');
  }
 
  /*dateTimePicker() {
    tail.DateTime(".tail-datetime-field", 
      { 
        dateFormat: "YYYY-mm-dd", 
        timeFormat: "HH:mm:ss"
      });        
  }*/

  createNewBatches() {
    console.log('In create new batches');
    for (let i = 0; i < 10; i++) {
        this.currentBatches[i] = {
        batchId:null,
        country: this.countries[i],
        status:"",
        percentCompleted:0,
        startDateTime:this.datepipe.transform(this.today, 'yyyy-MM-dd 13:30:00'),
        stopDateTime:null,
        batchDuration:null,
        remarks:""
      };
      this.startdt[i] = this.currentBatches[i].startDateTime;
    } 
  }

  public setTodaysBatch() {
    this.currentBatches = this.batches.filter(obj => {
      console.log("inside setTodaysbatches");
      return this.cutTimeFromInput(obj.startDateTime) == this.cutTimeFromInput(this.today);
    });
    for(let i=0; i<10; i++) {
      this.startdt[i] = this.currentBatches[i].startDateTime;
    }
  }

  getlatesBatchDate() {
    this.latestBatches = this.batches.filter(obj => {
      console.log("inside getlatesatchdate");
      if(this.cutTimeFromInput(obj.startDateTime) == this.cutTimeFromInput(this.today)) {
        this.latestBatchDate = obj.startDateTime; 
      }
      return this.cutTimeFromInput(obj.startDateTime) == this.cutTimeFromInput(this.today);
    })
  }


  converDateAndUpdate(batch: Batch, i) {
    if(this.isChangedSt[i] == true) {
      batch.startDateTime = this.datepipe.transform(this.startdt[i], 'yyyy-MM-dd HH:mm:ss');
      console.log('start ' + batch.startDateTime);
      this.isChangedSt[i] == false;
    }
    if(this.isChangedSp[i] == true) {
      batch.stopDateTime = this.datepipe.transform(this.stopdt[i], 'yyyy-MM-dd HH:mm:ss');
      console.log('stop ' + batch.stopDateTime);
      this.isChangedSp[i] == false;
      batch.batchDuration = this.currentBatches[i].batchDuration;
      //this.updateBatch(batch);
    }
  }


  public getAllBatches() {
    this.apiService.getAllBatches().subscribe(
      res => {
        console.log('inside get all batches method');
        console.log('today: ' + this.today);
        
        console.log('nextdate: ' + this.today);
        this.batches = res;
        

        console.log('after getAllBatches() method');
        this.getlatesBatchDate();
        if( this.cutTimeFromInput(this.latestBatchDate) != this.cutTimeFromInput(this.today)) {
          this.createNewBatches();
        }
        else {
          this.setTodaysBatch();
        }
      },
      err => {
        alert("An error has occurred;")
      }
    );
  }


  updateBatch(updatedBatch: Batch) {
    this.apiService.postBatch(updatedBatch).subscribe(
      res => {

      },  
      err => {alert("An error has occurred while saving the batch");
    console.log(err+'');}
    );
  }

  setCurrentStartDateTime(i) {
    let now = new Date();
    console.log("inside setCurrentDateTime: " + i);
      this.startdt[i] = this.datepipe.transform(now, 'yyyy-MM-dd HH:mm:ss');
      console.log("start dt "+this.startdt[i]);
  }

  setCurrentStopDateTime(i) {
    let now = new Date();
    console.log("inside setCurrentDateTime: " + i);
      this.stopdt[i] = this.datepipe.transform(now, 'yyyy-MM-dd HH:mm:ss');
      console.log("stop dt "+this.stopdt[i]);

  }

  submit() {
    this.apiService.clearVector().subscribe(
      res => {

      },  
      err => {alert("An error while clearing vector");}
    );

    for (let i = 0; i < 10; i++) {
      this.converDateAndUpdate(this.currentBatches[i], i);
      this.updateBatch(this.currentBatches[i]);
    }
    alert("Data submitted successfully");
  }


  sendEmail() : void {

      if(window.confirm("Are you sure you want to send batch email?")) {

    
    this.apiService.sendEmail().subscribe(
      res=>{
          //location.reload();
        // alert(''+res.resp);
       //  console.log(res.resp);
        console.log('inside ts');
          this.emailResponse = res;
          console.log(this.emailResponse.resp);
            alert(''+this.emailResponse.resp);
      },
      error=>{
        console.log('inside ts');

        console.log(error);
        alert('Email could not be sent');
      }
    );
      }
  }

  isChangedst(i) {
    //console.log('inside popup(): i = ' + i);
    //console.log("Before change: " + this.isChanged[i]);
    this.isChangedSt[i] = true;

   // console.log(new Date(this.startdt[i]));
    //console.log("After change: " + this.isChanged[i]);
    //alert("Value changed: " + this.isChanged[i]);
  }

  isChangedsp(i) {
    //console.log('inside popup(): i = ' + i);
    //console.log("Before change: " + this.isChangedsp[i]);
    this.isChangedSp[i] = true;
    //console.log("After change: " + this.isChanged[i]);
    //alert("Value changed: " + this.isChanged[i]);
  }

    calculateDuration(i){

      /*let stHours = st.substring(11,13);
      let stMinutes = st.substring(14,16);
      let enHours = stop;
      console.log("sthours: " + stHours);*/
  //  console.log('st:', st);
   // console.log('stopdt:', this.stopdt[i]);
    let startdate = new Date(this.startdt[i]);
    let stopdate = new Date(this.stopdt[i]);
    console.log("1 : "+startdate);
    console.log("2 : "+stopdate);

    console.log(stopdate.getTime()-startdate.getTime());
//let sst = new Date(st); 
//let edt = new Date(this.stopdt[i]);
//let difference = edt.getTime() - sst.getTime();
//console.log('diff : '+this.datepipe.transform(new Date((stopdate).getTime() - (startdate).getTime()), 'HH:mm:ss'));
    //this.calculatedDuration[i] =    ;
      //  this.calculatedDuration[i] = this.datepipe.transform(new Date((stopdate).valueOf() - (startdate).valueOf()), ' HH:mm:ss');
     // console.log();
   // this.calculatedDuration[i] = this.datepipe.transform(new Date((stopdate).getTime() - (startdate).getTime()), 'yyyy-MM-dd HH:mm:ss');
   
   this.msToHMS(stopdate.getTime()-startdate.getTime(),i);
    console.log("calculatedDuration:", this.calculatedDuration);
  }


 msToHMS(ms, i){


   let seconds = ms/1000;
   let hours =  parseInt((seconds)/3600);
   seconds = (seconds) % 3600;

   let minutes = parseInt((seconds)/60);
   seconds = seconds % 60;
   
    this.calculatedDuration[i] = hours+":"+minutes+":"+seconds;
    this.currentBatches[i].batchDuration = this.calculatedDuration[i];
 }
}

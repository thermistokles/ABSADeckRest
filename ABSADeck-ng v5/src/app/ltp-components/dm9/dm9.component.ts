import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Batch} from "../../batchstatus/model/batch";
import {ApiService} from "../../shared/api.service";
import * as XLSX from 'xlsx';
import { DatePipe } from '@angular/common';
import {formatDate} from '@angular/common';

declare var tail: any;

@Component({
  selector: 'app-dm9',
  templateUrl: './dm9.component.html',
  styleUrls: ['./dm9.component.css']
})
export class Dm9Component implements OnInit {

  countries :any = [];
  batches: Batch[] = [];
  batchesTemp: Batch[] = [];
  batchesDatewise: Batch[] = [];
  myCountry: string = "";
  batch: Batch;
  country: string = "";
  today = new Date();
  fromDate = "";
  toDate = "";
  selectedDate: string = "";
  constructor(private apiService: ApiService, public datepipe: DatePipe) { }

  ngOnInit() {
    this.getAllBatches();
    this.getAllBatchesTemp();
    this.countries = this.getCountries();
    console.log(this.countries);
    this.selectedDate = formatDate(new Date(), 'yyyy-MM-dd', 'en');
    tail.DateTime(".tail-datetime-field", 
    { 
      dateFormat: "YYYY-mm-dd", 
      timeFormat: false
    });
  }

  public getAllBatches() {
    this.apiService.getAllBatches().subscribe(
      res => {
        this.batches = res;
        this.batchesDatewise = this.batches;
      },
      err => {
        alert("An error has occurred;")
      }
    );
  }

  
  public getAllBatchesTemp() {
    this.apiService.getAllBatches().subscribe(
      res => {
        this.batchesTemp = res;
      },
      err => {
        alert("An error has occurred;")
      }
    );
  }

  getCountries() {
    return [
      { id: '0', name: 'All' },
      { id: '1', name: 'Mauritius' },
      { id: '2', name: 'Kenya' },
      { id: '3', name: 'Zambia' },
      { id: '4', name: 'Ghana' },
      { id: '5', name: 'NBC' },
      { id: '6', name: 'Uganda' },
      { id: '7', name: 'Seychelles' },
      { id: '8', name: 'BBT' },
      { id: '9', name: 'Mozambique' },
      { id: '10', name: 'Botswana' }
    ];
  }

  countryChanged(value:any){
   // console.log(value);
  // this.getAllBatches();
   
    this.country = this.countries.find(x => x.id === value).name;

    //console.log(this.country);
    
    this.getByCountry();
  }

  public getByCountry() {

  // this.getAllBatches();
   console.log(this.batches);


    this.batches = this.batchesDatewise.filter(obj => {
      return obj.country == this.country;
    })

    
    console.log(this.batches);
    console.log("after")
    
    if(this.country == "All"){
      this.selectedDate="";
      this.fromDate="";
      this.toDate="";
      this.getAllBatches();
    }
   

  }

  public getByDate() {
    this.fromDate="";
    this.toDate="";
    this.country="";

    //this.getAllBatchesTemp();
    //this.batches = this.batchesTemp.filter(obj => {

    console.log("inside getByDate");
    
    console.log("this.selectedDate: " + this.selectedDate);
    console.log("this.batchesTemp: " + this.batchesTemp);
    this.batchesDatewise = this.batchesTemp.filter(obj => {
      return this.datepipe.transform(obj.startDateTime, 'yyyy-MM-dd') === this.datepipe.transform(this.selectedDate, 'yyyy-MM-dd');
    })
    this.batches = this.batchesDatewise;
    
   
    if(this.selectedDate == ""){
      this.getAllBatches();
    }
  }

  public getByRange() {
    this.selectedDate="";
    this.country="";
    this.batchesDatewise = this.batchesTemp.filter(obj => {
      let fdt = new Date(this.fromDate);
      fdt.setHours(0,0,0,0);
      let tdt = new Date(this.toDate);
      tdt.setHours(0,0,0,0);
      console.log('from: ' + this.fromDate + ' to: ' + this.toDate);
      console.log('ojb.startDateTime: ' + obj.startDateTime);
      let batchDate = new Date(obj.startDateTime);
      console.log('batchDate: ' + batchDate);
      batchDate.setHours(0,0,0,0);
      console.log('batchDate.setHours : ' + batchDate);
      return (fdt <= batchDate) && (batchDate <= tdt);
    })
    this.batches = this.batchesDatewise;
    if(this.fromDate == "" && this.toDate == ""){
      this.getAllBatches();
    }
  }

  @ViewChild('TABLE', { static: false }) TABLE: ElementRef;
  downloadExcel() {
    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(this.TABLE.nativeElement);
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Batch');
    XLSX.writeFile(wb, 'Status_Report.xlsx');
  }
}

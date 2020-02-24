import { Component, OnInit } from '@angular/core';
import {Payment} from "../../payments/model/payment";
import {ApiService} from "../../shared/api.service";

@Component({
  selector: 'app-payment-view',
  templateUrl: './payment-view.component.html',
  styleUrls: ['./payment-view.component.css']
})
export class PaymentViewComponent implements OnInit {

  payments: Payment[] = [];
  selectedPayment: Payment;
  searchText: string;

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
    this.getAllPayment();
  }

  public getAllPayment() {
    this.apiService.getAllPayment().subscribe(
      res => {
        console.log("Hello");
        this.payments = res;
      },
      err => {
        alert("An error has occurred;")
      }
    );
  }

//   createSod() {
//     let newSod:Sod = {
//       Id:null,
//       appName: "",
//       statusDate:null,
//       status:"",
//       comments:""
//     };

//     this.apiService.postSod(newSod).subscribe(
//       res => {
//         newSod.Id = res.Id;
//         this.sods.push(newSod);
//       },
//       err => {alert("An error has occurred while saving the batch");}
//     );

//   }

//   updatePayment(updatedSod: Sod) {
//     this.apiService.postSod(updatedSod).subscribe(
//       res => {

//       },
//       err => {alert("An error has occurred while saving the payment");}
//     );
//   }

  

  selectPayment(payment: Payment) {
    
  }
}




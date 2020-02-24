import { Component, OnInit } from '@angular/core';
import {Payment} from "./model/payment";
import {ApiService} from "../shared/api.service";

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.css']
})
export class PaymentsComponent implements OnInit {

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
        this.payments = res;
      },
      err => {
        alert("An error has occurred;")
      }
    );
  }

  createPayment() {
    let newPayment:Payment = {
      paymentId:null,
      // country:"",
      payments:"",
      count:null,
      startDateTime:null,
      endDateTime:null,
      duration:null,
    };

    this.apiService.postPayment(newPayment).subscribe(
      res => {
        newPayment.paymentId = res.paymentId;
        this.payments.push(newPayment);
      },
      err => {alert("An error has occurred while saving the batch");}
    );

  }

  updatePayment(updatedPayment: Payment) {
    this.apiService.postPayment(updatedPayment).subscribe(
      res => {

      },
      err => {alert("An error has occurred while saving the payment");}
    );
  }

  deletePayment(payment: Payment) {
    if(confirm("Are you sure you want to delete payment?")){
      this.apiService.deletePayment(payment.paymentId).subscribe(
        res => {
          let indexOfPayment = this.payments.indexOf(payment);
          this.payments.splice(indexOfPayment,1);
        },
        err => {
          alert("Could not delete payment");
        }
      );
    }
  }

  selectPayment(payment: Payment) {

  }
}

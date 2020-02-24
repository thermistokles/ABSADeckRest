import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Batch } from "../batchstatus/model/batch";
import {Payment} from "../payments/model/payment";
import {Sod} from "../sod/model/sod";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  //batches
  private BASE_DM9_URL = "http://localhost:3000/dm9/batch";
  public ALL_DM9_BATCHES_URL = `${this.BASE_DM9_URL}/all`;
  private SAVE_UPDATE_NOTEBOOK = `${this.BASE_DM9_URL}`;
  private DELETE_NOTEBOOK_URL = `${this.BASE_DM9_URL}/`;
  private CLEAR_VECTOR = `${this.BASE_DM9_URL}/clearVector`;

  //payments
  private BASE_URL_PAYMENTS = "http://localhost:3000/dm9/payments";
  public ALL_PAYMENTS_URL = `${this.BASE_URL_PAYMENTS}/all`;
  private SAVE_UPDATE_PAYMENTS = `${this.BASE_URL_PAYMENTS}`;
  private DELETE_PAYMENTS_URL = `${this.BASE_URL_PAYMENTS}/`;

  //sod
  private BASE_URL_SOD = "http://localhost:3000/sod";
  public ALL_SOD_URL = `${this.BASE_URL_SOD}/getAllSOD`;
  private SAVE_UPDATE_SOD = `${this.BASE_URL_SOD}`;
  public ALL_SOD_REPORT_URL = `${this.BASE_URL_SOD}/sodreport`;


  //email
 private BASE_URL_EMAIL = "http://localhost:3000/dm9/batch/sendbatchemail";

  constructor(private http: HttpClient) {

  }


  //batches
  getAllBatches(): Observable<Batch[]> {
    return this.http.get<Batch[]>(this.ALL_DM9_BATCHES_URL);
  }


  postBatch(notebook: Batch): Observable<Batch> {
    return this.http.post<Batch>(this.SAVE_UPDATE_NOTEBOOK, notebook);
  }

  deleteBatch(id: number): Observable<any> {
    return this.http.delete(this.DELETE_NOTEBOOK_URL + id);
  }

  clearVector(): Observable<any> {
    return this.http.get<any>(this.CLEAR_VECTOR);
  }


  //payments

  getAllPayment(): Observable<Payment[]> {
    return this.http.get<Payment[]>(this.ALL_PAYMENTS_URL);
  }

  //email

   sendEmail(): Observable<any> {
    console.log('inside service');

    return this.http.get<any>(this.BASE_URL_EMAIL);
  }


  postPayment(notebook: Payment): Observable<Payment> {
    return this.http.post<Payment>(this.SAVE_UPDATE_PAYMENTS, notebook);
  }

  deletePayment(id: number): Observable<any> {
    return this.http.delete(this.DELETE_PAYMENTS_URL + id);
  }


  //sod

getAllSod(): Observable<Sod[]> {
    return this.http.get<Sod[]>(this.ALL_SOD_URL);
  }

   getSodReport(): Observable<Sod[]> {
    return this.http.get<Sod[]>(this.ALL_SOD_REPORT_URL);
  }


  postSod(notebook: Sod): Observable<Sod> {
    return this.http.post<Sod>(this.SAVE_UPDATE_SOD, notebook);
  }
}

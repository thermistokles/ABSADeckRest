import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {KamlsHealth} from "../kamls-health/model/kamlsHealth";

@Injectable({
  providedIn: 'root'
})
export class KamlsapiService {

  //kamls

  private BASE_KAMLS_URL = "http://localhost:3000/kamls/health";
  public ALL_KAMLS_BATCHES_URL = `${this.BASE_KAMLS_URL}/getAllKamlsHealth`;
  private SAVE_UPDATE_BATCH = `${this.BASE_KAMLS_URL}`;
  private DELETE_BATCH_URL = `${this.BASE_KAMLS_URL}/`;

  constructor(private http: HttpClient) {

  }

  getAllBatches(): Observable<KamlsHealth[]> {
    return this.http.get<KamlsHealth[]>(this.ALL_KAMLS_BATCHES_URL);
  }


  postBatch(BATCH: KamlsHealth): Observable<KamlsHealth> {
    return this.http.post<KamlsHealth>(this.SAVE_UPDATE_BATCH, BATCH);
  }

  deleteBatch(id: number): Observable<any> {
    return this.http.delete(this.DELETE_BATCH_URL + id);
  }
}

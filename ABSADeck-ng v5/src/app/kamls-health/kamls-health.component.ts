import { Component, OnInit } from '@angular/core';
import {KamlsHealth} from "./model/kamlsHealth";
import {KamlsapiService} from "../shared/kamlsapi.service";

@Component({
  selector: 'app-kamls-health',
  templateUrl: './kamls-health.component.html',
  styleUrls: ['./kamls-health.component.css']
})
export class KamlsHealthComponent implements OnInit {

  kamlsHealth: KamlsHealth[] = [];
  selectedBatch: KamlsHealth;
  searchText: string;

  constructor(private apiService: KamlsapiService) {
  }

  ngOnInit() {
    this.getAllBatches();
  }

  public getAllBatches() {
    this.apiService.getAllBatches().subscribe(
      res => {
        this.kamlsHealth = res;
      },
      err => {
        alert("An error has occurred;")
      }
    );
  }

  create() {

  }

  updatekamlsHealth(updatedKamlsHealth: KamlsHealth) {
    this.apiService.postBatch(updatedKamlsHealth).subscribe(
      res => {

      },
      err => {alert("An error has occurred while saving the batch");}
    );
  }

  selectBatch(KamlsHealth: KamlsHealth) {

  }

}

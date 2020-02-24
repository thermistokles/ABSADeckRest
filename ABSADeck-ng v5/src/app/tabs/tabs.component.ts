import { Component, OnInit } from '@angular/core';
import $ from "jquery";

declare var M: any;

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.component.html',
  styleUrls: ['./tabs.component.css']
})
export class TabsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    var el = document.querySelectorAll('.tabs');
    var instance = M.Tabs.init(el);
  }

}

import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

declare var M: any;


@Component({
  selector: 'app-loginnav',
  templateUrl: './loginnav.component.html',
  styleUrls: ['./loginnav.component.css']
})
export class LoginnavComponent implements OnInit {

  uname: String = "";
  pass: String = "";

  constructor(private router: Router) { }

  ngOnInit() {
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems);
  }

  onLogin() {

    if(this.uname === 'ltp' && this.pass==='lead') {
      this.router.navigate(['report/dm9/health']);
    }
    else if(this.uname === 'dhruv' && this.pass==='bindoria') {
      this.router.navigate(['dm9/health']);
    }
    else if(this.uname === 'isaac' && this.pass==='maria') {
      this.router.navigate(['dm9/health']);
    }
    else if(this.uname === 'ashwini' && this.pass==='password') {
      this.router.navigate(['dm9/health']);
    }
    else {
      this.router.navigate(['login']);
    }
    
 }

}

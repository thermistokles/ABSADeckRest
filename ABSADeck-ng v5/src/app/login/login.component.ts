import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) {
    
   }

  ngOnInit() {
  }


  uname: String = "";
  pass: String = "";


  onLogin() {

    if(this.uname === 'ltp') {
      this.router.navigate(['report/dm9/health']);
    }
    else if(this.uname === 'dhruv') {
      this.router.navigate(['dm9/health']);
    }
    else {
      this.router.navigate(['login']);
    }
    
 }

}

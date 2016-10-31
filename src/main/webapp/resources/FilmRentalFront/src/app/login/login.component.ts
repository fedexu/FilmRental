import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { Router } from '@angular/router';

import { Users } from '../models/Users';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  submitted = false;
  loginResult : string;
  pippo : string;
  model = new Users(18, 'Username', true);


  constructor(private restService: RestService, private router: Router){}

  onSubmit() {
    this.submitted = true;
    this.restService.logUser(this.model.username)
    .then(result =>{
        this.loginResult = result.toString();
        if(this.loginResult) this.router.navigate(['rest/admin']);
    });
   }



}

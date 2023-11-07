import { Component, OnInit } from '@angular/core';
import { userOperationsService } from '../services/userOperations/userOperations.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  
  email: string = '';
  password: string = '';

  constructor(private userOperationsService: userOperationsService) {}

  login() {
    this.userOperationsService.login(this.email, this.password);
  }
}

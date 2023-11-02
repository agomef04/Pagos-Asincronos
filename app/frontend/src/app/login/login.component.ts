import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/userOperations/userOperations.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  
  email: string = '';
  password: string = '';
  textoInput: string = '';

  constructor(private loginService: LoginService) {}

  login() {
    this.loginService.login(this.email, this.password);
  }
}

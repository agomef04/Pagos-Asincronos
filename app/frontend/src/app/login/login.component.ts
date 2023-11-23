import { Component, OnInit } from '@angular/core';
import { userOperationsService } from '../services/userOperations/userOperations.service';
import { websocketTransacciones } from '../services/websocketTransacciones/websocket-transacciones.service';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  
  email: string = '';
  password: string = '';

  constructor(private userOperationsService: userOperationsService, private websocketTransacciones: websocketTransacciones) {}

  login() {
    this.userOperationsService.login(this.email, this.password);
    this.conectarWebsocket();
  }

  conectarWebsocket(){
    this.websocketTransacciones.connect(this.email);
  }
}

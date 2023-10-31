import { Component, OnInit } from '@angular/core';
import { WebsocketService } from '../services/websocket/websocket.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  textoInput: string = '';

  constructor(private websocketService: WebsocketService) {}

  login() {
    this.websocketService.connect(this.email, this.password);
  }
}

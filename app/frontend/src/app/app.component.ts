import { Component } from '@angular/core';
import { WebsocketService } from './websocket.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'pagina-login';
  input = '';
  constructor(public websocketService: WebsocketService) {}

  sendMessage() {
    if(this.input) {
      this.websocketService.sendMessage(this.input);
      this.input = '';
    }
  }
}


import { Component } from '@angular/core';
import { websocketTransacciones } from './services/websocketTransacciones/websocket-transacciones.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'pagina-login';
  input = '';
  constructor(public websocketService: websocketTransacciones) {}

}


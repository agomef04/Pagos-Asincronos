import { Component, OnInit } from '@angular/core';
import { userOperationsService } from './../services/userOperations/userOperations.service';
import { websocketTransacciones } from './../services/websocketTransacciones/websocket-transacciones.service';

@Component({
  selector: 'app-header-component',
  templateUrl: './header-component.component.html',
  styleUrls: ['./header-component.component.css']
})
export class HeaderComponentComponent implements OnInit {
  constructor(private userOps: userOperationsService, private websocketTransacciones: websocketTransacciones) {}

  datoUsuario = {
    numberOrigin: this.userOps.phoneNumber,
    name: this.userOps.name,
    email: this.userOps.email
  };

  ngOnInit() {
    //this.websocketTransacciones.connect(this.userOps.email)
  }
  
}

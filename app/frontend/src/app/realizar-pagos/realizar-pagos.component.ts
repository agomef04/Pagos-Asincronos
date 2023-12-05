import { Component } from '@angular/core';
import { websocketTransacciones } from './../services/websocketTransacciones/websocket-transacciones.service';
import { userOperationsService } from './../services/userOperations/userOperations.service';



@Component({
  selector: 'app-realizar-pagos',
  templateUrl: './realizar-pagos.component.html',
  styleUrls: ['./realizar-pagos.component.css']
})
export class RealizarPagosComponent {

  numberOrigin: string = this.userOperationsService.phoneNumber;
  numberDestination: string = '';
  concept: string = '';
  amount: number = 0;

  constructor(private webSocketService: websocketTransacciones, private userOperationsService: userOperationsService) {}

  onSubmit() {
    console.log('Tlf destino: ', this.numberDestination);
    console.log('Amount: ', this.amount);
    console.log('Concept: ', this.concept);
    this.webSocketService.sendMoney(this.numberDestination, this.amount, this.concept, this.numberOrigin);
  }
}

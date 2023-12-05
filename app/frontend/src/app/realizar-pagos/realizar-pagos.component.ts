import { Component } from '@angular/core';
import { WebsocketService } from '../websocket.service';



@Component({
  selector: 'app-realizar-pagos',
  templateUrl: './realizar-pagos.component.html',
  styleUrls: ['./realizar-pagos.component.css']
})
export class RealizarPagosComponent {

  numberOrigin: string = '';
  numberDestination: string = '';
  concept: string = '';
  amount: number = 0;

  constructor(private webSocketService: WebsocketService) {}

  sendMessage() {
    if (this.numberDestination) {
      this.webSocketService.sendMessage(this.numberDestination);
      this.numberDestination = '';
    }
  }


  onSubmit() {
    console.log('Tlf destino: ', this.numberDestination);
    console.log('Amount: ', this.amount);
    console.log('Concept: ', this.concept);
  }
}
